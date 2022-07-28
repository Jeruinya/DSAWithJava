package com.scaler.dsa.arrays;

/*
Given a 2D array which is sorted along the rows and columns and you are given an element X to search in the array.

A[][]=    1  2 	4  	8
		  5  7  10 	12
		  11 15 20  32
		  18 25 30  40
 */
public class StrairCaseSearchProblem {

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 4, 8 }, { 5, 7, 10, 12 }, { 11, 15, 20, 32 }, { 18, 25, 30, 40 } };

		int x = 20;

		boolean res = isElementPresentNaive(A, x);
		System.out.println(res);

		boolean res1 = isElementPresentEfficient(A, x);
		System.out.println(res1);

	}

	//TC-O(N+M)
	private static boolean isElementPresentEfficient(int[][] A, int x) {
		int i = 0;
		int j = A[0].length - 1;
		while (i < A.length - 1 && A[0].length - 1 >= 0) {
			if (A[i][j] > x)
				j--;
			else if (A[i][j] < x)
				i++;
			else
				return true;
		}
		return false;
	}

	// TC-O(N^2)
	private static boolean isElementPresentNaive(int[][] A, int x) {
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[0].length; j++)
				if (A[i][j] == x)
					return true;
		return false;
	}

}
