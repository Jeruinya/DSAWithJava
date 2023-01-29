package com.scaler.dsa.matrix;

/*
Problem Description
Given an array, A of integers of size N. Find the maximum value of j - i such that A[i] <= A[j].

Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109

Input Format
First argument is an integer array A of size N.

Output Format
Return an integer denoting the maximum value of j - i.

Input 1:A = [3, 5, 4, 2]
Input 2:A = [4, 1, 3, 0]

Output 1:2
Output 2:1

Explanation 1:
For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2. 

Explanation 2:
For A[1] = 1 and A[2] = 3, the ans is (2 - 1) = 1. 
 */
public class R_MaxDistance {

	public static void main(String[] args) {
		int A[] = { 3, 5, 4, 2 };
		System.out.println(maximumGap(A));

	}

	public static int maximumGap(final int[] A) {
		int n = A.length;
		int rmax[] = new int[n];
		int i, j, max = -1;
		// rmax stores the maximum element in the suffix
		for (i = n - 1; i >= 0; i--) {
			rmax[i] = (i == n - 1 || A[i] > rmax[i + 1]) ? A[i] : rmax[i + 1];
		}
		for (i = 0, j = 0; i < n && j < n;) {
			if (A[i] <= rmax[j]) {
				if (j - i > max)
					max = j - i;
				j++;
			} else {
				i++;
			}
		}
		return max;
	}

}
