package com.scaler.dsa.arrays;

import java.util.Scanner;

public class FindAllNegativeNumInArr {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		for (int i = 0; i < n; i++) {
			if (arr[i] < 0)
				System.out.print(arr[i] + " ");
		}

	}
}