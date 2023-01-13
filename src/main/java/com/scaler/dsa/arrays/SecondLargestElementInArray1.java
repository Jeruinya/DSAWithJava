package com.scaler.dsa.arrays;

public class SecondLargestElementInArray1 {

	public static void main(String[] args) {
		int A[] = { 10, 2, 4, 54, 87, 23, 100, 40 };

		System.out.println(solve(A));
	}

	// This code will fail when array is containing duplicate elements
	public static int solve(int[] A) {
		int largest = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > A[largest])
				largest = i;
		}
		int res = -1;
		for (int i = 0; i < A.length; i++) {
			if (i != largest) {
				res = Math.max(res, A[i]);
			}
		}

		return res;

	}
}
