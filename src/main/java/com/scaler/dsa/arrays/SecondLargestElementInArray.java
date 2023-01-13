package com.scaler.dsa.arrays;

public class SecondLargestElementInArray {

	public static void main(String[] args) {
		int A[] = { 100,10, 2, 4, 54, 87, 23, 100, 40 };

		System.out.println(getSecondLargestElementNaive(A));
		int i = getSecondLargestElementEfficient(A);
		System.out.println(A[i]);
	}

	private static int getSecondLargestElementNaive(int[] A) {
		int n = A.length;
		int second = Integer.MIN_VALUE;
		int largest = getFirstLargestElementEfficient(A);
		for (int i = 0; i < n; i++) {
			if (A[i] != largest) {
				if (second == Integer.MIN_VALUE)
					second = A[i];
				else if (A[i] > second)
					second = A[i];
			}
		}
		return second;
	}

	private static int getFirstLargestElementEfficient(int[] A) {
		int largest = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > largest)
				largest = A[i];
		}
		return largest;
	}

	private static int getSecondLargestElementEfficient(int[] A) {
		int n = A.length;
		int secondLargest = -1, largest = 0;

		for (int i = 1; i < n; i++) {
			if (A[i] > A[largest]) {
				secondLargest = largest;
				largest = i;
			} else if (A[i] != A[largest]) {
				if (secondLargest == -1 || A[i] > A[secondLargest])
					secondLargest = i;
			}
		}
		return secondLargest;
	}
}
