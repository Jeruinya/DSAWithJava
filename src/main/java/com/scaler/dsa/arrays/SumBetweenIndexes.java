package com.scaler.dsa.arrays;

import java.util.Arrays;

public class SumBetweenIndexes {

	public static void main(String[] args) {
		int A[] = { 7, 3, 1, 5, 5, 5, 1, 2, 4, 5 };
		int B[][] = { { 7, 10 }, { 3, 10 }, { 3, 5 }, { 1, 10 } };

		int n = A.length;
		int m = B.length;
		long[] pref = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			pref[i] = pref[i - 1] + A[i - 1];
		}
		long[] ans = new long[m];
		for (int i = 0; i < m; i++) {
			int s = B[i][0];
			int e = B[i][1];
			ans[i] = pref[e] - pref[s - 1];
		}
		System.out.println(Arrays.toString(ans));
	}

}

/*
 * int ps[] = new int[A.length]; long sumArr[] = new long[B.length]; ps[0] =
 * A[0]; for (int i = 1; i < A.length; i++) ps[i] = ps[i - 1] + A[i];
 * 
 * for (int i = 0; i < B.length; i++) { int arr[] = B[i]; int s = arr[0]; int e
 * = arr[1]-1; int sum = ps[e] - ps[s - 1]; sumArr[i] = sum;
 * 
 * } System.out.println(Arrays.toString(sumArr)); } }
 */