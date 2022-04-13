package com.scaler.dsa.matrix;

/*
 * WAP to print the two main diagonals of the matrix
 */
public class PrintDiagonals {

	public static void main(String[] args) {

		int arr[][] = { { 1, 2, 3, 4 }, 
						{ 5, 6, 7, 8 }, 
						{ 9, 10, 11, 12 }, 
						{ 13, 14, 15, 16 } };

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i][i]);

	}
}
