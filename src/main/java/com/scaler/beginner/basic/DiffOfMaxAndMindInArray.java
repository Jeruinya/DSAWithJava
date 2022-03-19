package com.scaler.beginner.basic;

public class DiffOfMaxAndMindInArray {

	public static void main(String[] args) {
		int A[]= {-15,-45,43,23,-63,69,35,19,37,-52};
		int res = 0;
		int maxEven = 0;
		int minOdd = 0;

		for (int i = 0; i < A.length; i++)
			if (A[i] % 2 == 0 && A[i] > maxEven)
				maxEven = A[i];

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 != 0) {
				minOdd = A[i];
				break;
			}
		}

		for (int i = 0; i < A.length; i++)
			if (A[i] % 2 != 0 && A[i] < minOdd)
				minOdd = A[i];

		System.out.println(maxEven - minOdd);
	}
}
