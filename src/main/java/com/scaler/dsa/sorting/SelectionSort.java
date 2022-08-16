package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Select the minimum element and put it at front.
its in place algorithm.
its unstable algo which means it will not maintain the insertion order in case there are duplicates.
O(n^2)
 */
public class SelectionSort {

	public static void main(String[] args) {
		int A[] = { 64, 25, 12, 22, 11 };
		selectionSort(A);
		System.out.println(Arrays.toString(A));
	}

	private static void selectionSort(int[] A) {
		int n = A.length;
		for (int i = 0; i < n - 1; i++) {
			int idx = i;
			for (int j = i + 1; j < n; j++) {
				if (A[j] < A[idx])
					idx = j;
			}
			int temp = A[i];
			A[i] = A[idx];
			A[idx] = temp;
		}

	}

}
