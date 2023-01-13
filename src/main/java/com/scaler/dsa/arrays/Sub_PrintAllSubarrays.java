package com.scaler.dsa.arrays;

public class Sub_PrintAllSubarrays {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3 };
		printAllSubarrays(A);

	}

	private static void printAllSubarrays(int[] A) {
		int n = A.length;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				printSubarray(A, i, j);
				System.out.println();
			}
		}

	}

	private static void printSubarray(int[] A, int s, int e) {
		for (int i = s; i <= e; i++)
			System.out.print(A[i] + " ");

	}

}
