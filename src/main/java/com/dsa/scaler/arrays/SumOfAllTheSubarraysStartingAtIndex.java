package com.dsa.scaler.arrays;

public class SumOfAllTheSubarraysStartingAtIndex {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		int startingIndex = 2;

		sumOfAllSubArrayStartingFromIndex(arr, n, startingIndex);
		System.out.println("Sum of all the subarrays:");
		sumOfAllSubArray(arr, n);
	}
	
	//from O(n^3) O(1)-->O(n^2) O(n) using Prefix sum------>O(n^2) O(1) using carry forward
	private static void sumOfAllSubArray(int[] arr, int n) {
		for (int s = 0; s < n; s++) {
			int sum = 0;
			for (int e = s; e < n; e++) {
				sum = sum + arr[e];
				System.out.println(sum);
			}
			System.out.println();
			
		}

	}

	// O(n) O(1)
	private static int sumOfAllSubArrayStartingFromIndex(int[] arr, int n, int startingIndex) {
		int sum = 0;

		for (int i = startingIndex; i < n; i++) {
			sum = sum + arr[i];
			System.out.println(sum);
		}
		return sum;
	}

}
