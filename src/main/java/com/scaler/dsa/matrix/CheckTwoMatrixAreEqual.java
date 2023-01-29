package com.scaler.dsa.matrix;

/*
Problem Description
You are given two matrices A & B of equal dimensions and you have to check whether two matrices are equal or not.
NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.

Problem Constraints
1 <= A.size(), B.size() <= 1000
1 <= A[i].size(), B[i].size() <= 1000
1 <= A[i][j], B[i][j] <= 1000

Input Format
First argument is vector of vector of integers representing matrix A.
Second argument is vector of vector of integers representing matrix B.

Output Format
Return 1 if both matrices are equal or return 0.

Input 1:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[7, 8, 9],[4, 5, 6]]

Output 1:1
Output 2:0

Explanation 1:
==> Clearly all the elements of both matrices are equal at respective positions.

Explanation 2:
==> Clearly all the elements of both matrices are not equal at respective positions.
 */
public class CheckTwoMatrixAreEqual {

	public static void main(String[] args) {

		int A[][] = { { 50, 20, 30 }, { 60, 30, 10 }, { 30, 80, 10 } };
		int B[][] = { { 50, 20, 30 }, { 60, 30, 10 }, { 30, 80, 10 } };
		System.out.println(isEqual(A, B));
	}

	private static int isEqual(int[][] A, int[][] B) {
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[0].length; j++)
				if (A[i][j] != B[i][j])
					return 0;
		return 1;

	}
}
