package com.scaler.dsa.arrays;

import java.util.Arrays;

public class SumBetweenIndexes {

	public static void main(String[] args) {
		int A[] = { 7, 3, 1, 5, 5, 5, 1, 2, 4, 5 };
		int B[][] = { { 7, 10 }, { 3, 10 }, { 3, 5 }, { 1, 10 } };
		System.out.println(Arrays.toString(rangeSum(A, B)));
	}

	public static long[] rangeSum(int[] A, int[][] B) {
		int n = A.length;
		int m = B.length;
		long[] pref = new long[n];
		pref[0] = A[0];
		for (int i = 1; i < n; i++) {
			pref[i] = pref[i - 1] + A[i];
		}
		long[] ans = new long[m];
		for (int i = 0; i < m; i++) {
			int s = B[i][0] - 1;
			int e = B[i][1] - 1;
			if (s == 0)
				ans[i] = pref[e];
			else
				ans[i] = pref[e] - pref[s - 1];
		}
		return ans;
	}
}