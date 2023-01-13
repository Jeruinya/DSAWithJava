package com.scaler.dsa.arrays;

public class Sub_PrintSumOfAllSubarrays {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3 };

		printAllSubarrays(A);
		System.out.println();
		printAllSubarraysUsingPrefixSum(A);

	}

	private static void printAllSubarraysUsingPrefixSum(int[] A) {
		int n = A.length;
		int ps[] = new int[n];
		ps[0] = A[0];
		for (int i = 1; i < n; i++)
			ps[i] = ps[i - 1] + A[i];

		for (int s = 0; s < n; s++) {
			int sum = 0;
			for (int e = s; e < n; e++) {
				if (s == 0)
					sum = ps[e];
				else
					sum = ps[e] - ps[s - 1];
				System.out.println(sum);
			}
		}
	}

	private static void printAllSubarrays(int[] A) {
		int n = A.length;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = printSumSubarray(A, i, j);
				System.out.println(sum);
			}
		}

	}

	private static int printSumSubarray(int[] A, int s, int e) {
		int sum = 0;
		for (int i = s; i <= e; i++) 
			sum = sum + A[i];
		return sum;
	}

}
