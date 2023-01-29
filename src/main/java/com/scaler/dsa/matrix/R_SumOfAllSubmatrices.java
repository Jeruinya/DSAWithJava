package com.scaler.dsa.matrix;

/*
Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible sub matrices.

Problem Constraints
1 <= N <=30
0 <= A[i][j] <= 10

Input Format
Single argument representing a 2-D array A of size N x N.

Output Format
Return an integer denoting the sum of all possible sub matrices in the given matrix.

Input
A = [ [1, 1]
      [1, 1] ]

Output
16


Example Explanation

Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
Total Sum = 4+8+4 = 16

Note-For a N*M matrices, the number of sub matrices is equal to = N*(N-1)/2 * M(M-1)/2
 */
public class R_SumOfAllSubmatrices {

	public static void main(String[] args) {
		int A[][] = { { 1, 1 }, { 1, 1 } };
		System.out.println(solve(A));

	}

	public static int solve(int A[][]) {
		int n = A.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Number of sub matrices contain A[i][j]
				int times = (i + 1) * (j + 1) * (n - i) * (n - j);
				sum += times * A[i][j];
			}
		}
		return sum;
	}
}
