package com.scaler.arrays;

import java.util.Scanner;

/**
 * Write a program to input N numbers array from user and insert an element Y in
 * it at specified position X.
 * Problem Constraints
 * 1 <= N <= 100
 * 1 <= A[i] <= 1000
 * 1 <= X <= N
 * 1 <= Y <= 1000
 */

public class InsertElementInArray {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n + 1];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		int pos = s.nextInt();
		int key = s.nextInt();
		insetAtX(arr, key, pos, n);

		for (int i = 0; i <= n; i++)
			System.out.print(arr[i] + " ");

	}

	public static int insetAtX(int arr[], int key, int pos, int n) {

		for (int i = n - 1; i >= pos - 1; i--)
			arr[i + 1] = arr[i];

		arr[pos - 1] = key;
		return n + 1;
	}
}