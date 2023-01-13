package com.scaler.dsa.arrays;

/*
Given an array, return the length of the smallest subarray which contains both the maximum and minimum element.
A[] = { 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 } 
max=6
min=1

and the length of the smallest sub array is 3 i.e {6,4,1}

Observation:
1:In the answer subarray the max and min element have to be on the corner element.
2:In the answer subarray there have to be only one max and only one min element.

Approach: for every min, find the closest max in right side. And for every max find the closest min on the right side.

 */

public class Sub_FindSmallestSubArrayWithMaxAndMinElements {

	public static void main(String[] args) {
		int A[] = { 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 };

		System.out.println(smallestSubarrayWithMinAndMaxElemNaive(A));

		System.out.println(smallestSubarrayWithMinAndMaxElemEfficient(A));

	}

	// O(n) and O(1)
	private static int smallestSubarrayWithMinAndMaxElemEfficient(int[] A) {
		int ans = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int latest_max_idx = Integer.MIN_VALUE;
		int latest_min_idx = Integer.MIN_VALUE;
		int n = A.length;

		for (int i = 0; i < n; i++)
			if (A[i] > max)
				max = A[i];
		for (int i = 0; i < n; i++)
			if (A[i] < min)
				min = A[i];

		if (max == min)
			return 1;

		for (int i = 0; i < n; i++) {
			if (A[i] == max) {
				latest_max_idx = i;
				if (latest_min_idx >= 0)
					ans = Math.min(ans, i - latest_min_idx + 1);

			} else if (A[i] == min) {
				latest_min_idx = i;
				if (latest_max_idx >= 0)
					ans = Math.min(ans, i - latest_max_idx + 1);
			}
		}

		return ans;
	}

	// Tc=O(N2) , SC--O(1)
	private static int smallestSubarrayWithMinAndMaxElemNaive(int[] A) {
		int ans = Integer.MAX_VALUE;
		int n = A.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int start = -1, end = -1;

		for (int i = 0; i < n; i++)
			if (A[i] > max)
				max = A[i];
		for (int i = 0; i < n; i++)
			if (A[i] < min)
				min = A[i];

		for (int i = 0; i < n; i++) {
			if (A[i] == max) {
				for (int j = i; j < n; j++) {
					if (A[j] == min) {
						ans = Math.min(ans, j - i + 1);
						start = i;
						end = j;
						break;
					}
				}
			} else if (A[i] == min) {
				for (int j = i; j < n; j++) {
					if (A[j] == max) {
						ans = Math.min(ans, j - i + 1);
						start = i;
						end = j;
						break;
					}
				}
			}
		}

		for (int i = start; i <= end; i++)
			System.out.println(A[i]);

		return ans;
	}

}
