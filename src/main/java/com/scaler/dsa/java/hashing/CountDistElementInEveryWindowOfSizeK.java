package com.scaler.dsa.java.hashing;

import java.util.HashMap;



public class CountDistElementInEveryWindowOfSizeK {
	public static void main(String[] args) {
		int arr[] = new int[] { 10, 10, 5, 3, 20, 5 };
		int n = arr.length;
		int k = 4;
		printDistinctNaive(arr, n, k);
		printDistinctEfficient(arr, n, k);

	}

	static void printDistinctEfficient(int arr[], int n, int k) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 0; i < k; i++) {
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
		}
		System.out.print(m.size() + " ");

		for (int i = k; i < n; i++) {
			m.put(arr[i - k], m.get(arr[i - k]) - 1);
			if (m.get(arr[i - k]) == 0) {
				m.remove(arr[i - k]);
			}
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
			System.out.print(m.size() + " ");
		}
	}

	static void printDistinctNaive(int arr[], int n, int k) {
		for (int i = 0; i <= n - k; i++) {
			int count = 0;
			for (int j = 0; j < k; j++) {
				boolean flag = false;
				for (int p = 0; p < j; p++) {
					if (arr[i + j] == arr[i + p]) {
						flag = true;
						break;
					}
				}
				if (flag == false)
					count++;

			}
			System.out.print(count + " ");
		}
	}
}