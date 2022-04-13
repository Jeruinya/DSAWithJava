package com.scaler.dsa.java.hashing;

public class SubarrayWithGivenSumNaive {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 8, 6, 13, 3, -1 };
		int sum = 22;
		int n = arr.length;

		System.out.println(isSum(arr, n, sum));
	}

	static boolean isSum(int arr[], int n, int sum) {
		for (int i = 0; i < n; i++) {
			int curr_sum = 0;
			for (int j = i; j < n; j++) {
				curr_sum += arr[j];
				if (curr_sum == sum)
					return true;
			}
		}
		return false;
	}
}