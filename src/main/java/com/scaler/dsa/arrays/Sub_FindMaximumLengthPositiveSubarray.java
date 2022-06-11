package com.scaler.dsa.arrays;

import java.util.Arrays;

/**
 * Problem Description Given an array of integers A, of size N. Return the
 * maximum size subarray of A having only non-negative elements. If there are
 * more than one such subarray, return the one having the smallest starting
 * index in A.
 * 
 * NOTE: It is guaranteed that an answer always exists.
 * 
 * Output Format: Return maximum size subarray of A having only non-negative
 * elements. If there are more than one such subarrays, return the one having
 * earliest starting index in A.
 * 
 * Input 1: A = [5, 6, -1, 7, 8] Input 2: A = [1, 2, 3, 4, 5, 6]
 *
 * Output 1: [5, 6] Output 2: [1, 2, 3, 4, 5, 6]
 */

public class Sub_FindMaximumLengthPositiveSubarray {

	public static void main(String[] args) {

		// int A[] = {-4549634, -3196682, 8455838, -1432628, -263819, -3928366,
		// -5556259, -2114783, 3923939, -4183708};

		int A[] = { -5173778, -8176176, 1694510, 7089884, -1394259, 1146372, -2502339, 1544618, 6602022, 4330572 };
		int n = A.length;

		int i = 0, j = 0, end = -1, start = 0;
		while (i < n && j < n) {
			if (A[j] >= 0)
				j++;
			else {
				if (j - i > end - start + 1) {
					start = i;
					end = j - 1;
				}
				i = j + 1;
				j++;
			}
		}
		if (j - i > end - start + 1) {
			start = i;
			end = j - 1;
		}

		int arr[] = new int[end - start + 1];
		int indx = start;
		for (int k = 0; k < end - start + 1; k++)
			arr[k] = A[indx++];

		System.out.println(Arrays.toString(arr));

	}
}