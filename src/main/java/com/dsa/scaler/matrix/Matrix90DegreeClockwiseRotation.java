package com.dsa.scaler.matrix;

/**
 Problem Description:You are given a n x n 2D matrix A representing an image.
Rotate the image by 90 degrees (clockwise).
You need to do this in place.
[ [1, 2],[3, 4]]
 
 [[3, 1],[4, 2]]
Note: If you end up using an additional array, you will only receive partial score.
 */

import java.util.Arrays;

public class Matrix90DegreeClockwiseRotation {

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };

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
