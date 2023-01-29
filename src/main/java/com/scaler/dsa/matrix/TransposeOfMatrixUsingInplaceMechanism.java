package com.scaler.dsa.matrix;

import java.util.Arrays;

/*
Problem Description

You are given a matrix A, you have to return another matrix which is the transpose of A.
NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row. 
The tranpose of a matrix switches the element at (i, j)th index to (j, i)th index, 
and the element at (j, i)th index to (i, j)th index.

Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000

Input Format
First argument is a 2D matrix of integers.
Output Format
You have to return the Transpose of this 2D matrix.


Input 1:A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:A = [[1, 2],[1, 2],[1, 2]]

Output 1:
[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2:
[[1, 1, 1], [2, 2, 2]]

Explanation 1:
Cearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
 
 In place transpose is only possible when matrix is square matrix
 
If the matrix is symmetric in size, we can transpose the matrix inplace by mirroring the 2D 
array across it’s diagonal.
 */

public class TransposeOfMatrixUsingInplaceMechanism {

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;
			}
		}
		for (int i = 0; i < n; i++)
			System.out.println(Arrays.toString(A[i]));

	}

}
