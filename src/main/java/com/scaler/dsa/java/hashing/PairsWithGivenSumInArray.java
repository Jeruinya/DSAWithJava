package com.scaler.dsa.java.hashing;

import java.util.HashSet;

public class PairsWithGivenSumInArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 8, 4, 7, 6, 1 };
		int len = arr.length;
		int x = 14;
		System.out.println(pairWithSumX(arr, len, x));
	}

	//Number of pairs could be-{3,8},{8,4},{4,7},{7,6},{6,1},......
	//Number of pairs=n*(n-1)/2
	static int pairWithSumX(int arr[], int n, int X) {
		HashSet<Integer> us = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (us.contains(X - arr[i]))
				return 1;

			us.add(arr[i]);
		}
		return 0;

	}
}