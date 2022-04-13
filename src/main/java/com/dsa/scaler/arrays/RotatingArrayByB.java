package com.dsa.scaler.arrays;

import java.util.Scanner;

/**
 * Problem Description
 * Given an integer array A and an integer B, you have to print the same array
 * after rotating it B times towards the right.
 * NOTE: You can use extra memory.
 */

public class RotatingArrayByB {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		int b = s.nextInt() % n;

		reverse(arr, 0, n - 1);
		reverse(arr, 0, b - 1);
		reverse(arr, b, n - 1);

		for (int arr1 : arr)
			System.out.print(arr1 + " ");
	}

	public static void reverse(int[] A, int start, int end) {
		int i, j;
		for (i = start, j = end; i < j; i++, j--) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}

}
