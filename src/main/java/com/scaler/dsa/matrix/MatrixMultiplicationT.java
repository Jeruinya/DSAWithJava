package com.scaler.dsa.matrix;

import java.util.Arrays;

public class MatrixMultiplicationT {

	public static void main(String[] args) {

		int[][] A = { { 94, 91 } };
		int B[][] = { { 35, -52, -12, 26, -93, -61 }, { 29, -20, -36, -9, 66, 15 } };

		int m = A.length;
		int p = B[0].length;
		int row2=B.length;

		int arr[][] = new int[m][p];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < p; j++)
				for(int k=0;k<row2;k++)
				arr[i][j] = arr[i][j]+A[i][k] * B[k][j];
		
		for(int i=0;i<arr.length;i++)
			System.out.println(Arrays.toString(arr[i]));

	}
}