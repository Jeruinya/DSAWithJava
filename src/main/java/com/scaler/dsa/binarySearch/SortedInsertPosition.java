package com.scaler.dsa.binarySearch;

/*
Problem Description
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= N <= 106

Input Format
The first argument is an integer array A of size N.
The second argument is an integer B.

Output Format
Return an integer denoting the index of target value.
Input 1:A = [1, 3, 5, 6]  B = 5 
Input 2:A = [1] B = 1

Output 1:2 

Explanation 1:
The target value is present at index 2. 
Explanation 2:

The target value is present at index 0.
 */
public class SortedInsertPosition {

	public static void main(String[] args) {
		int A[] = { 3, 5, 8, 10, 15, 20, 25 };
		int t = 9;
		System.out.println(binarySearch(A, t));
	}

	public static int binarySearch(int A[], int B) {
		int s = 0;
		int e = A.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (A[mid] == B)
				return mid;
			else if (A[mid] > B)
				e = mid - 1;
			else
				s = mid + 1;
		}
		return s;
	}
}
