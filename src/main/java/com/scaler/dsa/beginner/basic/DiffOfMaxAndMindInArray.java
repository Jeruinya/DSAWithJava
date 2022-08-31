package com.scaler.dsa.beginner.basic;

public class DiffOfMaxAndMindInArray {

	public static void main(String[] args) {
		int A[]= {-15,-45,43,23,-63,69,35,19,37,-52};
		int maxEven = Integer.MIN_VALUE;
		int minOdd =Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++)
			if (A[i] % 2 == 0 && A[i] > maxEven)
				maxEven = A[i];

		for (int i = 0; i < A.length; i++)
			if (A[i] % 2 != 0 && A[i] < minOdd)
				minOdd = A[i];

		System.out.println(maxEven - minOdd);
	}
}
