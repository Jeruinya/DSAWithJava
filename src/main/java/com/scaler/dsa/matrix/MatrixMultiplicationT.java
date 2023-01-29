package com.scaler.dsa.matrix;

import java.util.Arrays;

/*
Problem Description
You are given two integer matrices A(having M X N size) and B(having N X P). 
You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).

Problem Constraints
1 <= M, N, P <= 100
-100 <= A[i][j], B[i][j] <= 100

Input Format
There are 2 lines in the input
First line: Two integers R, C are the number of rows and columns. 
Then R * C integers follow corresponding to the row wise numbers in the 2D array.

Second line: Two integer R, C are the number of rows and columns. 
Then R * C integers follow corresponding to the row wise numbers in the 2D array.

Output Format
Return a 2D integer matrix denoting AB.

Input 1:
2 2 1 2 3 4
2 2 5 6 7 8
Input 2:
1 2 1 1
2 1 2 3

Output 1:
 [[19, 22],
  [43, 50]]
Output 2:
 [[5]]

Explanation 2:
 [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
 
 */
public class MatrixMultiplicationT {

	public static void main(String[] args) {

		int[][] A = { { 94, 91 } };
		int B[][] = { { 35, -52, -12, 26, -93, -61 }, { 29, -20, -36, -9, 66, 15 } };

		int m = A.length;
		int p = B[0].length;
		int row2 = B.length;

		int arr[][] = new int[m][p];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < p; j++)
				for (int k = 0; k < row2; k++)
					arr[i][j] = arr[i][j] + A[i][k] * B[k][j];

		for (int i = 0; i < arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));

	}
}