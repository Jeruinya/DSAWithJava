package com.scaler.dsa.arrays;

public class Sub_SumOfAllTheSubarraysStartingAtIndex {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		sumOfAllSubArray(A);
	}

	// from O(n^3) O(1)-->O(n^2) O(n) using Prefix sum------>O(n^2) O(1) using carry
	// forward
	private static void sumOfAllSubArray(int[] A) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum = sum + A[j];
				System.out.println(sum);
			}
			System.out.println();
		}
	}
}
