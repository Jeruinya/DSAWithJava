package com.scaler.dsa.arrays;

/**
 * Problem Description Given an array of size N, find the subarray of size K
 * with the least average.
 * 
 * Input Format :First argument contains an array A of integers of size N.Second argument contains integer k.
 * 
 * Output Format : Return the index of the first element of the subarray of size k that has least average.Array indexing starts from 0.
 * 
 * start index could be 0,1,2,3,4,......n-k;
 * here initial start index is 0 and we will update as if we find a subarray with minimum value later.
 */
public class Sub_FindMinAvgSubarray {

	public static void main(String[] args) {

		int A[] = { 15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18 };
		int B = 6;
		int n = A.length;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = A[i];

		int firstIndex = findMinAvgSubarray(arr, n, B);
		System.out.println(firstIndex);
	}

	public static int findMinAvgSubarray(int arr[], int n, int k) {
		int res_index = 0;

		int cur_sum = 0;
		for (int i = 0; i < k; i++)
			cur_sum += arr[i];

		int min_sum = cur_sum;

		for (int i = k; i < n; i++) {
			cur_sum += arr[i] - arr[i - k];

			if (cur_sum < min_sum) {
				min_sum = cur_sum;
				res_index = i - k + 1;
			}
		}
		return res_index;
	}
}
