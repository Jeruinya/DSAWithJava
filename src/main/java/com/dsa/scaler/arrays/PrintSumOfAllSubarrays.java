package com.dsa.scaler.arrays;

public class PrintSumOfAllSubarrays {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;

		int ps[] = new int[n];
		ps[0] = arr[0];
		for (int i = 1; i < n; i++)
			ps[i] = ps[i - 1] + arr[i];

		//O(n^3) O(1) 
		printAllSubarraysUsingPrefixSum(arr, ps, n);
		//O(n^2) O(n)
		printAllSubarrays(arr, n);

	}

	private static void printAllSubarraysUsingPrefixSum(int[] arr, int[] ps, int n) {

		for (int s = 0; s < n; s++) {
			int sum = 0;
			for (int e = s; e < n; e++) {
				if (s == 0)
					sum = ps[e];
				else
					sum = ps[e] - ps[s - 1];
				System.out.println(sum);
			}
			System.out.println();
			
		}

	}

	private static void printAllSubarrays(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = printSumSubarray(arr, i, j);
				System.out.println(sum);
			}
		}

	}

	private static int printSumSubarray(int[] arr, int s, int e) {
		int sum = 0;
		for (int i = s; i <= e; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

}
