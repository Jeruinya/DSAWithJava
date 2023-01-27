package com.scaler.dsa.java.hashing;
/*
Given two arrays of equal length, find largest common subarray with equal number of 0s and 1s
 */
import java.util.HashMap;

public class LongestCommonSubarrayWithSameSumInBinaryArrays {

	public static void main(String args[]) {
		int[] A1 = { 1, 1, 1, 1 };
		int[] A2 = { 1, 1, 0, 1 };
		int n = A1.length;
		System.out.println(longestCommonSum(A1, A2, n));
	}

	// Returns largest common subarray with equal
	// number of 0s and 1s
	static int longestCommonSum(int[] A1, int A2[], int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = A1[i] - A2[i];

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		int sum = 0;
		int max_len = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0)
				max_len = i + 1;

			if (hm.containsKey(sum))
				max_len = Math.max(max_len, i - hm.get(sum));

			else
				hm.put(sum, i);
		}
		return max_len;
	}
}