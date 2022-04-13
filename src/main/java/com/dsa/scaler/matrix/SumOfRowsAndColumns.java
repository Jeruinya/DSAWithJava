package com.dsa.scaler.matrix;

import java.util.Arrays;

public class SumOfRowsAndColumns {

	public static void main(String[] args) {

		int a[][] = { { 2, 3, 4 }, { 1, 2, 3 }, { 9, 8, 7 } };

		int b[] = new int[a.length + a[0].length];

		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = 0; j < a[0].length; j++) {
				sum = sum + a[i][j];
			}
			b[i] = sum;
		}

		for (int i = 0; i < a[0].length; i++) {
			int sum = 0;
			for (int j = 0; j < a.length; j++) {
				sum = sum + a[j][i];
			}
			b[i + a.length] = sum;
		}
		System.out.println(Arrays.toString(b));
	}

}
