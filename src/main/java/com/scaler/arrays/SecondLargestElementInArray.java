package com.scaler.arrays;

public class SecondLargestElementInArray {

	public static void main(String[] args) {
		int arr[] = { 10, 2, 4, 54, 87, 23, 100, 40 };

		int n = arr.length;
		int index = getSecondLargestElementNaive(arr, n);
		System.out.println(arr[index]);
		int index1 = getSecondLargestElementEfficient(arr, n);
		System.out.println(arr[index1]);
	}

	private static int getSecondLargestElementNaive(int[] arr, int n) {

		int res = -1;
		int largest = getFirstLargestElementEfficient(arr, n);
		for (int i = 0; i < n; i++) {
			if (arr[i] != arr[largest]) {
				if (res == -1)
					res = i;
				else if (arr[i] > arr[res])
					res = i;
			}
		}
		return res;
	}

	private static int getSecondLargestElementEfficient(int[] arr, int n) {
		int res = -1, largest = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[largest]) {
				res = largest;
				largest = i;
			} else if (arr[i] != arr[largest]) {
				if (res == -1 || arr[i] > arr[res])
					res = i;
			}
		}
		return res;
	}

	private static int getFirstLargestElementEfficient(int[] arr, int n) {
		int res = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[res])
				res = i;
		}
		return res;
	}

}
