package com.scaler.dsa.matrix;

import java.util.Arrays;

/*
Problem Description
You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
1 <= A[i][j] <= 103

Input Format
First argument is a 2D array of integers.(2D matrix).

Output Format
Return an array conatining column-wise sums of original matrix.

Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

Output 1:{15,10,13,16}

Explanation 1
Column 1 = 1+5+9 = 15
Column 2 = 2+6+2 = 10
Column 3 = 3+7+3 = 13
Column 4 = 4+8+4 = 16
 */
public class ColumnWiseSum {

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 2, 3, 4 } };
		System.out.println(Arrays.toString(solve(A)));

	}

	public static int[] solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int arr[] = new int[m];

		for (int j = 0; j < m; j++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum = sum + A[i][j];
			}
			arr[j] = sum;
		}

		return arr;

	}

}
