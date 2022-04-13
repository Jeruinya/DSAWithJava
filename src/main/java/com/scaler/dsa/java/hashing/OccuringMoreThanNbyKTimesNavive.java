package com.scaler.dsa.java.hashing;

import java.util.Arrays;

public class OccuringMoreThanNbyKTimesNavive {
	
	public static void main(String[] args) {
		int arr[] = new int[] { 10, 10, 20, 30, 20, 10, 10 };
		int n = arr.length;
		int k = 2;
		printNByKOccurrences(arr, n, k);
	}

	static void printNByKOccurrences(int arr[], int n, int k) {
		Arrays.sort(arr);
		int i = 1, count = 1;
		while (i < n) {
			while (i < n && arr[i] == arr[i - 1]) {
				count++;
				i++;
			}
			if (count > n / k)
				System.out.print(arr[i - 1] + " ");
			count = 1;
			i++;
		}

	}

}
