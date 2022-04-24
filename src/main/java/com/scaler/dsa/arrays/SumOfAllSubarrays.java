package com.scaler.dsa.arrays;

/**
 * Problem Description You are given an integer array A of length N. You have to
 * find the sum of all subarray sums of A. More formally, a subarray is defined
 * as a contiguous part of an array which we can obtain by deleting zero or more
 * elements from either end of the array. A subarray sum denotes the sum of all
 * the elements of that subarray.
 * 
 * Output Format--->Return a single integer denoting the sum of all subarray sums of the given array.
 */

public class SumOfAllSubarrays {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3 };

		long sum = subarraySum(A);
		System.out.println(sum);

	}

	public static long subarraySum(int[] A) {
		int n = A.length;
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans = ans + (long) A[i] * (i + 1) * (n - i);
		}
		return ans;
	}
}
