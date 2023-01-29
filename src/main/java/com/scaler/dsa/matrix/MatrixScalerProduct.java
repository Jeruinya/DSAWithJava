package com.scaler.dsa.matrix;

import java.util.Arrays;

/*
Problem Description
You are given a matrix A and and an integer B, you have to perform scalar multiplication of 
matrix A with an integer B.

Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000
1 <= B <= 1000

Input Format
First argument is 2D array of integers A representing matrix.
Second argument is an integer B.

Output Format
You have to return a 2D array of integers after doing required operations.

Input 1:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = 2 

Output 1:[[2, 4, 6], [8, 10, 12], [14, 16, 18]]

Explanation 1:
==> ( [[1, 2, 3],[4, 5, 6],[7, 8, 9]] ) * 2
==> [[2*1, 2*2, 2*3],[2*4, 2*5, 2*6],[2*7, 2*8, 2*9]]
==> [[2, 4, 6], [8, 10, 12], [14, 16, 18]]
 */
public class MatrixScalerProduct {

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int B = 2;
		int res[][] = solve(A, B);
		for (int i = 0; i < res.length; i++)
			System.out.println(Arrays.toString(A[i]));

	}

	public static int[][] solve(int[][] A, int B) {
		int m = A.length;
		int n = A[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = A[i][j] * B;
		return A;
	}

}
