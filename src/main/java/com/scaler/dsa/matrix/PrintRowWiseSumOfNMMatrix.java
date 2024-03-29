package com.scaler.dsa.matrix;

import java.util.Arrays;

/*
Problem Description
You are given a 2D integer matrix A, return a 1D integer array containing row-wise sums of original matrix.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
1 <= A[i][j] <= 103

Input Format
First argument A is a 2D array of integers.(2D matrix).

Output Format
Return an array conatining row-wise sums of original matrix.

Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

Output 1:[10,26,18]

Explanation 1
Row 1 = 1+2+3+4 = 10
Row 2 = 5+6+7+8 = 26
Row 3 = 9+2+3+4 = 18
 */
public class PrintRowWiseSumOfNMMatrix {

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 2, 3, 4 } };
		System.out.println(Arrays.toString(solve(A)));
	}

	public static int[] solve(int[][] A) {

		int m = A.length;
		int n = A[0].length;
		int arr[] = new int[m];
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += A[i][j];
			}
			arr[i] = sum;
		}
		return arr;
	}

}
