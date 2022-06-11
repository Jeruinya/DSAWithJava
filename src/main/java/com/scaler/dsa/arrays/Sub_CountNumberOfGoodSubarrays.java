package com.scaler.dsa.arrays;

/**
 * Problem Description Given an array of integers A, a subarray of an array is
 * said to be good if it fulfills any one of the criteria: 1. Length of the
 * subarray is be even, and the sum of all the elements of the subarray must be
 * less than B. 2. Length of the subarray is be odd, and the sum of all the
 * elements of the subarray must be greater than B. Your task is to find the
 * count of good subarrays in A.
 * 
 * Input Format :The first argument given is the integer array A. The second
 * argument given is an integer B.
 * 
 * Output Format: Return the count of good subarrays in A.
 */
public class Sub_CountNumberOfGoodSubarrays {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int B = 4;
		int count = countNumberOfGoodSubarrays(A, B);
		System.out.println(count);
	}

	private static int countNumberOfGoodSubarrays(int[] A, int B) {
		int n = A.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			int c = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				c++;

				if ((sum < B && c % 2 == 0) || (sum > B && c % 2 != 0))
					count++;
			}
		}
		return count;
	}

}
