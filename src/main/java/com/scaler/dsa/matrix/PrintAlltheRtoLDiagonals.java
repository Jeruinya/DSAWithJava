package com.scaler.dsa.matrix;

public class PrintAlltheRtoLDiagonals {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 }, { 12, 13, 14 } };

		int n = arr.length;
		int m = arr[0].length;
		for (int j = 0; j < m; j++) {
			int x = 0, y = j;
			while (x < n && y >= 0) {
				System.out.print(arr[x][y] + " ");
				x++;
				y--;
			}
		}
		System.out.println();

		System.out.println("Daigonals starting from M-1th column");

		for (int i = 1; i < n; i++) {
			int x = i, y = m-1;
			while (x <n && y >= 0) {
				System.out.print(arr[x][y]+" ");
				x++;
				y--;
			}
		}
	}
}
