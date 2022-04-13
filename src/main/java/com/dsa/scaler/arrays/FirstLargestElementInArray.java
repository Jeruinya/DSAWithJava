package com.dsa.scaler.arrays;

public class FirstLargestElementInArray {

	public static void main(String[] args) {
		int arr[] = { 10, 2, 4, 54, 87, 23, 100, 40 };

		int n = arr.length;
		int index = getFirstLargestElementNaive(arr, n);
		System.out.println(arr[index]);
		int index1 = getFirstLargestElementEfficient(arr, n);
		System.out.println(arr[index1]);
	}

	// O(N power 2)
	private static int getFirstLargestElementNaive(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (arr[j] > arr[i]) {
					flag = false;
					break;
				}
			}
			if (flag == true)
				return i;
		}
		return -1;
	}

	//O(n)
	private static int getFirstLargestElementEfficient(int[] arr, int n) {
		int res = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[res])
				res = i;
		}
		return res;
	}

}
