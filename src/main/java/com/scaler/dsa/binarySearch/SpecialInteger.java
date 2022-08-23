package com.scaler.dsa.binarySearch;

/*
Problem Description
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray 
in A of size K with the sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9
Input Format
The first argument given is the integer array A.
The second argument given is integer B.
Output Format
Return the maximum value of K (sub array length).

Input 1:A = [1, 2, 3, 4, 5] B = 10
Input 2:A = [5, 17, 100, 11] B = 130

Output 1: 2
Output 2: 3

Explanation 1:

Constraints are satisfied for maximal value of 2.
Explanation 2:

Constraints are satisfied for maximal value of 3
 */
public class SpecialInteger {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int B = 10;
		System.out.println(findSubarrayLength(A, B));
	}

	private static int findSubarrayLength(int[] A, int B) {
		int s = 0;
		int n = A.length;
		int e = n;
		long ans = 0;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (isPossible(A, B, mid)) {
				ans = mid;
				s = mid + 1;
			} else
				e = mid - 1;
		}

		return (int) ans;
	}

	public static boolean isPossible(int A[], int B, int range) {
		long sum = 0;
		for (int i = 0; i < range; i++)
			sum = sum + A[i];
		if (sum > B)
			return false;
		for (int i = range; i < A.length; i++) {
			sum = sum + A[i] - A[i - range];
			if (sum > B)
				return false;
		}
		return true;
	}

	public int solve(int[] A, int B) {
		int N = A.length;
		int l = 0, ans = N;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i];
			while (sum > B) {
				sum -= A[l++];
				if (ans > i - l) {
					ans = i - l;
				}
			}
			if (sum == 0) {
				return 0;
			}
		}
		return Math.min(ans + 1, N);
	}
}