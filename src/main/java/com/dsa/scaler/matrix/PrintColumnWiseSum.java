package com.dsa.scaler.matrix;

/**
 * Given array of [n][m],find the max column sum.
 */

public class PrintColumnWiseSum {

	public static void main(String[] args) {
		
		int max_col_sum=Integer.MIN_VALUE;
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		for (int j = 0; j < arr[0].length; j++) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum = sum + arr[i][j];
			}
			max_col_sum=Math.max(max_col_sum, sum);
		}
		
		System.out.println(max_col_sum);

	}

}
