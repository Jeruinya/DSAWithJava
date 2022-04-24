package com.scaler.dsa.matrix;

import java.util.Arrays;

//To find the transpose of a matrix using in place mechanism matrix must be of n*n.

public class TransposeOfMatrixUsingInplaceMechanism {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(arr[i]));

	}

}
