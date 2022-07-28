package com.scaler.dsa.matrix;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem Description You are given a 2D integer matrix A, make all the
 * elements in a row or column zero if the A[i][j] = 0. Specifically, make
 * entire ith row and jth column zero.
 * 
 * Input 1: [1,2,3,4] [5,6,7,0] [9,2,0,4]
 * 
 * Output 1: [1,2,0,0] [0,0,0,0] [0,0,0,0]
 */

public class RowToColumnZero {

	public static void main(String[] args) {

		int A[][] = { { 2, 3, 4, 3 }, { 2, 0, 7, 1 }, { 6, 5, 8, 1 }, { 1, 0, 2, 9 } };
		int A1[][] = { { 2, 3, 4, 3 }, { 2, 0, 7, 1 }, { 6, 5, 8, 1 }, { 1, 0, 2, 9 } };

		comvertRowColumnZero(A);

		for (int i = 0; i < A.length; i++)
			System.out.println(Arrays.toString(A[i]));

		comvertRowColumnZeroEfficient(A1);

		
		System.out.println();
		System.out.println();
		for (int i = 0; i < A1.length; i++)
			System.out.println(Arrays.toString(A1[i]));

	}

	private static void comvertRowColumnZeroEfficient(int[][] A1) {
		HashSet<Integer> rhs = new HashSet<>();
		HashSet<Integer> chs = new HashSet<>();
		for (int i = 0; i < A1.length; i++) {
			for (int j = 0; j < A1[0].length; j++) {
				if (A1[i][j] == 0) {
					rhs.add(i);
					chs.add(j);
				}
			}
		}

		for (int row : rhs)
			for (int k = 0; k < A1[0].length; k++)
				A1[row][k] = 0;

		for (int col : chs)
			for (int k = 0; k < A1.length; k++)
				A1[k][col] = 0;
	}

	// TC- O(N^2)
	private static void comvertRowColumnZero(int[][] A) {
		int n = A.length, m = A[0].length;
		for (int i = 0; i < n; i++) {
			int flag = 0;
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 0)
					flag = 1;
			}
			if (flag == 1) {
				for (int j = 0; j < m; j++) {
					if (A[i][j] != 0)
						A[i][j] = -1;
				}
			}
		}
		for (int j = 0; j < m; j++) {
			int flag = 0;
			for (int i = 0; i < n; i++) {
				if (A[i][j] == 0)
					flag = 1;
			}
			if (flag == 1) {
				for (int i = 0; i < n; i++) {
					if (A[i][j] != 0)
						A[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == -1)
					A[i][j] = 0;
			}
		}

	}

}
