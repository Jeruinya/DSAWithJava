package com.scaler.arrays;

/**
 * Q2. Count ways to make sum of odd and even indexed elements equal by removing an array element
 * 
 * Problem Description * 
 * Given an array, arr[] of size N, the task is to find the count of array
 * indices such that removing an element from these indices makes the sum of
 * even-indexed and odd-indexed array elements equal.
 * 
 * Output Format
 *Return the count of array indices such that removing an element from these indices makes the sum of even-indexed 
 *and odd-indexed array elements equal.
 * 
 */

public class CountNumberOfSpecialIndexesInArray {

	public static void main(String[] args) {
		int A[] = { 2, 1, 6, 4 };
		int n = A.length;
		int count = countSpecialIndexes(A, n);
		System.out.println(count);
	}

	public static int countSpecialIndexes(int[] A, int n) {

		int pso[] = new int[n];
		int pse[] = new int[n];

		pse[0] = A[0];
		pso[0] = 0;
		for (int i = 1; i < n; i++) {
			if (i % 2 == 0)
				pse[i] = pse[i - 1] + A[i];
			else
				pse[i] = pse[i - 1];
		}

		for (int i = 1; i < n; i++) {
			if (i % 2 != 0)
				pso[i] = pso[i - 1] + A[i];
			else
				pso[i] = pso[i - 1];
		}
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (pse[n - 1] == pso[n - 1])
					count++;
			} else {
				int Se = pse[i - 1] + pso[n - 1] - pso[i];
				int Ro = pso[i - 1] + pse[n - 1] - pse[i];
				if (Se == Ro)
					count++;
			}
		}

		return count;
	}
}
