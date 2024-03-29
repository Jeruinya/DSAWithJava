package com.scaler.dsa.dp;

/*
Problem Description
Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) 
which has the largest product.

Return an integer corresponding to the maximum product possible.
NOTE: Answer will fit in 32-bit integer value.


Problem Constraints
1 <= N <= 5 * 105
-100 <= A[i] <= 100

Input Format
First and only argument is an integer array A.

Output Format
Return an integer corresponding to the maximum product possible.

Input 1: A = [4, 2, -5, 1]
Input 2: A = [-3, 0, -5, 0]

Output 1: 8
Output 2: 0

Explanation 1:
 We can choose the subarray [4, 2] such that the maximum product is 8.

Explanation 2:
 0 will be the maximum product possible.
 */
public class MaxProductSubarray {

	public static void main(String[] args) {
		int A[] = { 4, 2, -5, 1 };
		System.out.println(maxProduct(A));

	}

	public static int maxProduct(final int[] A) {

		int dpMin[] = new int[A.length];
		int dpMax[] = new int[A.length];

		dpMin[0] = A[0];
		dpMax[0] = A[0];
		int ans = dpMax[0];
		for (int i = 1; i < A.length; i++) {
			dpMin[i] = Math.min(Math.min(A[i], A[i] * dpMin[i - 1]), A[i] * dpMax[i - 1]);
			dpMax[i] = Math.max(Math.max(A[i], A[i] * dpMin[i - 1]), A[i] * dpMax[i - 1]);
			ans = Math.max(ans, dpMax[i]);
		}

		return ans;
	}
}
