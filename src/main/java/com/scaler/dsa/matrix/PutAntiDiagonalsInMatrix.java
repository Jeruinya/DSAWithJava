package com.scaler.dsa.matrix;

import java.util.Arrays;

/**
 * Problem Description:
 * Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details
 * 
 *Input Format: First argument is an integer N, denoting the size of square 2D matrix.Second argument is a 2D array A of size N * N.
 *Output Format: Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
 *The vacant spaces in the grid should be assigned to 0.
 *
Input 1:
	1 2 3
	4 5 6
	7 8 9
Example Output:
	1 0 0
	2 4 0
	3 5 7
	6 8 0
	9 0 0
 * 
 */

public class PutAntiDiagonalsInMatrix {

	public static void main(String[] args) {

		int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = A.length;
		// int n=2*m-1;

		int arr[][] = new int[2 * n - 1][n];
		int j = 0;
		for (; j < n; j++) {
			int x = 0, y = j;
			while (x < n && y >= 0) {
				arr[j][x] = A[x][y];
				x++;
				y--;
			}
		}

		for (int i = 1; i < n; i++) {
			int x = i;
			int y = n - 1;
			int col = 0;
			while (x < n && y >= 0) {
				arr[j][col] = A[x][y];
				x++;
				y--;
				col++;
			}
			j++;
		}
		for (int i = 0; i < arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
}