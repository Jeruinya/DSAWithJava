package com.scaler.dsa.arrays;

public class SumOfArrayBetweenTwoIndexes {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 3, 4, 6, 8, 11 };
		int s = 1, e = 5;
		System.out.println(sumOfSubArray(A, s, e));

	}

	private static int sumOfSubArray(int[] A, int s, int e) {
		int sum = 0;
		for (int i = s; i <= e; i++)
			sum = sum + A[i];
		return sum;

	}

}
