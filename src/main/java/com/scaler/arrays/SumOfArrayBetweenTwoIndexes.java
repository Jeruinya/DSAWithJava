package com.scaler.arrays;

public class SumOfArrayBetweenTwoIndexes {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 3, 4, 6, 8, 11 };
		int s = 1, e = 5;
		int sum = sumOfSubArrayNaive(arr, s, e);
		System.out.println(sum);

	}

	private static int sumOfSubArrayNaive(int[] arr, int s, int e) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = s; j <= e; j++) {
				sum = sum + arr[j];
			}
			break;
		}
		return sum;

	}

}
