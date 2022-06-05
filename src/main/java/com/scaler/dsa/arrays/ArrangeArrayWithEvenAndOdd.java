package com.scaler.dsa.arrays;

/*
Given an array of N elements, arrange the array with even first and then odd elements.
 */
public class ArrangeArrayWithEvenAndOdd {

	public static void main(String args[]) {
		int arr[] = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int n = arr.length;

		rearrangeEvenAndOdd(arr, n);

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	private static void rearrangeEvenAndOdd(int[] A, int n) {

		int i = 0;
		while (i < n) {
			if (A[i] % 2 == 0) {
				i++;
			} else if (A[n - 1] % 2 != 0) {
				n--;
			} else {
				int temp = A[i];
				A[i] = A[n - 1];
				A[n - 1] = temp;
				i++;
				n--;
			}
		}
	}
}