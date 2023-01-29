package com.scaler.dsa.matrix;

/*
Problem Description
You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
Note: If you end up using an additional array, you will only receive partial score.

Problem Constraints
1 <= n <= 1000

Input Format
First argument is a 2D matrix A of integers

Output Format
Return the 2D rotated matrix.

Input 1:
 [
    [1, 2],
    [3, 4]
 ]
Input 2: [[1]]

Output 1:
 [
    [3, 1],
    [4, 2]
 ]
Output 2:

 [
    [1]
 ]

Explanation 1:
 After rotating the matrix by 90 degree:
 1 goes to 2, 2 goes to 4
 4 goes to 3, 3 goes to 1

Explanation 2:
 2D array remains the same as there is only element.
 
Approach: i-Find transpose and then  reverse the columns
 */

import java.util.Arrays;

public class Matrix90DegreeClockwiseRotation {

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// find transpose of the array A

		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A[i].length; j++) {
				int temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;

			}

		}

		int i = 0, j = A.length - 1;

		// reverse the columns

		while (i <= j) {
			for (int k = 0; k < A.length; k++) {
				int temp = A[k][i];
				A[k][i] = A[k][j];
				A[k][j] = temp;

			}
			i++;
			j--;
		}

		for (int k = 0; k < A.length; k++)
			System.out.println(Arrays.toString(A[k]));
	}

}
