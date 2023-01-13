package com.scaler.dsa.arrays;

import java.util.Arrays;

public class ReversingArray {

	public static void main(String[] args) {
		int A[] = { 10, 2, 3, 32, 54, 78, 90, 70, 40 };
		reverseArray(A);
		System.out.println(Arrays.toString(A));
	}

	// T.C-O(n) and S.C-O(1)
	private static void reverseArray(int[] A) {

		int low = 0, high = A.length - 1;
		while (low < high) {
			int temp = A[low];
			A[low] = A[high];
			A[high] = temp;
			low++;
			high--;
		}
	}
}
