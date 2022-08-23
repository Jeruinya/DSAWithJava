package com.interview.questions;

import java.util.List;

/*
Problem Description
Given a sorted array of integers A of size N and an integer B.
array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value B to search. If found in the array, return its index otherwise, return -1.
You may assume no duplicate exists in the array.
NOTE: Users are expected to solve this in O(log(N)) time.


Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are distinct.

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return index of B in array A, otherwise return -1

Input 1:A = [4, 5, 6, 7, 0, 1, 2, 3] B = 4 
Input 2:A = [1] B = 1

Output 1: 0 
Output 2: 0

Explanation 1: 
Target 4 is found at index 0 in A. 
Explanation 2: 
Target 1 is found at index 0 in A.

Dry run on below arrays:
{6,7,8,0,1,2,3,4,5}
{2,3,4,5,6,7,8,0,1}
{4,5,6,7,8,0,1,2,3}
 */
public class SearchTargetInRotatedSortedArray {

	public static void main(String[] args) {
		int A[] = { 7, 8, 0, 1, 2, 3, 4, 5, 6 };
		int T = 5;
		System.out.println(binarySearchNaive(A, T));
		System.out.println(binarySearchEff(A, T));

	}

	private static int binarySearchNaive(int[] A, int T) {
		for (int i = 0; i < A.length; i++)
			if (A[i] == T)
				return i;
		return -1;
	}

	private static int binarySearchEff(int[] A, int B) {
		int n = A.length;
		int l = 0;
		int h = n - 1;

		while (l <= h) {
			int mid = (l + h) / 2;
			if (A[mid] == B)
				return mid;
			else if (A[mid] >= A[l]) {
				if (B <= A[mid] && B >= A[l])
					h = mid - 1;
				else
					l = mid + 1;

			} else {
				if (B >= A[mid] && B <= A[h])
					l = mid + 1;
				else
					h = mid - 1;
			}
		}
		return -1;
	}

	public int search(final List<Integer> A, int B) {
		int start, end;
		int count;
		int num;
		int n = A.size();
		count = n;
		// find the index of minimum element
		int pivot = getMinElementIndex(A);
		// Now we can binary search in two parts 0 - pivot and pivot to n-2
		start = pivot;
		end = n - 1;
		int res = binarySearch(A, start, end, B);
		if (res == -1) {
			start = 0;
			end = pivot - 1;
			res = binarySearch(A, start, end, B);
		}
		return res;
	}

	public static int binarySearch(final List<Integer> A, int start, int end, int B) {
		int count = end - start + 1;
		int num, mid;
		while (count > 0) {
			mid = start + (end - start) / 2;
			num = A.get(mid);
			if (B == num)
				return mid;
			if (B < num)
				end = mid - 1;
			else
				start = mid + 1;
			count /= 2;
		}
		return -1;
	}

	public static int getMinElementIndex(final List<Integer> A) {
		int first, last, start, end;
		int count, num, n;
		int mid;
		int next, prev;
		n = A.size();
		count = n;
		first = A.get(0);
		last = A.get(n - 1);
		start = 0;
		end = n - 1;
		while (count > 0) {
			mid = start + (end - start) / 2;
			num = A.get(mid);
			next = A.get((mid + 1) % n);
			prev = A.get((mid - 1 + n) % n);
			if (num < prev && num < next) {
				return mid;
			}
			if (num > first && num > last)
				start = mid + 1;
			else
				end = mid - 1;
			count /= 2;
		}
		return -1;
	}

}
