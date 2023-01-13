package com.scaler.dsa.arrays;

import java.util.Arrays;

/*
 Problem Description
 Given an integer array A and an integer B, you have to print the same array
 after rotating it B times towards the right.
 NOTE: You can use extra memory.
 */

public class RotatingArrayToRightByB {

	public static void main(String[] args) {

		int A[] = { 1, 2, 3, 4, 5 };
		int n = A.length;
		int b = 3;
		b = b % n;

		reverse(A, 0, n - 1);
		reverse(A, 0, b - 1);
		reverse(A, b, n - 1);
		System.out.println(Arrays.toString(A));
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
