package com.scaler.dsa.arrays;

public class Sub_FindSumOfAllTheSubarraysSum {

	public static void main(String[] args) {
		int A[] = { 10, 20, 30 };
		System.out.println(sumOfAllSubarraysSum(A));

		System.out.println(sumOfAllSubarraysSumEfficient(A));

	}

	// O(n) O(1)
	private static int sumOfAllSubarraysSumEfficient(int[] A) {
		int ans = 0;
		int n = A.length;
		for (int i = 0; i < n; i++)
			ans += A[i] * (i + 1) * (n - i);
		return ans;
	}

	// O(n^2) O(1)
	private static int sumOfAllSubarraysSum(int[] A) {
		int ans = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum = sum + A[j];
				ans = ans + sum;
			}
		}
		return ans;
	}

}
