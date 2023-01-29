package com.scaler.dsa.matrix;

import java.util.Arrays;

/*
Problem Description
You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.

Problem Constraints
1 <= A.size(), B.size() <= 1000
1 <= A[i].size(), B[i].size() <= 1000
1 <= A[i][j], B[i][j] <= 1000

Input Format
The first argument is the 2D integer array A
The second argument is the 2D integer array B

Output Format
You have to return a vector of vector of integers after doing required operations.


Input 1:
A = [[1, 2, 3], 
     [4, 5, 6], 
     [7, 8, 9]]

B = [[9, 8, 7], 
     [6, 5, 4], 
     [3, 2, 1]]

Output 1:
[[10, 10, 10], 
 [10, 10, 10], 
 [10, 10, 10]]


Explanation 1:
A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10, 10, 10]].
 */
public class AdditionOfTwoMatrix {

	public static void main(String[] args) {
		int A[][] = { { 50, 20, 30 }, { 60, 30, 10 }, { 30, 80, 10 } };
		int B[][] = { { 10, 10, 5 }, { 20, 10, 12 }, { 23, 21, 12 } };

		int c[][] = new int[A.length][A[0].length];

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				c[i][j] = A[i][j] + B[i][j];

		for (int i = 0; i < A.length; i++) {
			System.out.print(Arrays.toString(c[i]));
		}
	}

	public static int[][] solve(int[][] A, int[][] B) {

		int n = A.length;
		int m = A[0].length;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				A[i][j] = A[i][j] + B[i][j];

		return A;
	}

}
