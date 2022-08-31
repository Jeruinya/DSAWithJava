package com.scaler.dsa.twoPointer;

/*
Given three sorted arrays A, B and Cof not necessarily same sizes.
Calculate the minimum absolute difference between the maximum and minimum number 
from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. 
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Input:
A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:
1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
public class MinimizeAbsoluteDifference {

	public static void main(String[] args) {
		int A[] = { 1, 4, 5, 8, 10 };
		int B[] = { 6, 9, 15 };
		int C[] = { 2, 3, 6, 6 };
		System.out.println(printMinimumDiff(A, B, C));
	}

	public static int printMinimumDiff(int[] A, int[] B, int[] C) {

		int n = A.length;
		int m = B.length;
		int o = C.length;
		int i = 0;
		int j = 0;
		int k = 0;

		int ans = Integer.MAX_VALUE;

		while (i < n && j < m && k < o) {
			int min = Math.min(A[i], Math.min(B[j], C[k]));
			int max = Math.max(A[i], Math.max(B[j], C[k]));

			int absDiff = Math.abs(max - min);
			ans = Math.min(absDiff, ans);
			
			if (min == A[i])
				i++;
			else if (min == B[j])
				j++;
			else
				k++;
		}
		return ans;
	}
}
