package com.dsa.scaler.arrays;

public class PrintAllSubarrays {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		printAllSubarrays(arr, n);

	}

	private static void printAllSubarrays(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				printSubarray(arr, i, j);
				System.out.println();
			}
		}

	}

	private static void printSubarray(int[] arr, int s, int e) {
		for (int i = s; i <= e; i++)
			System.out.print(arr[i] + " ");

	}

}
