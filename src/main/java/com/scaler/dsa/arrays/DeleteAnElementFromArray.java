package com.scaler.dsa.arrays;

import java.util.Scanner;

public class DeleteAnElementFromArray {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		int index = s.nextInt();
		for (int i = index - 1; i < n -1; i++)
			arr[i] = arr[i + 1];

		for (int i = 0; i < n - 1; i++)
			System.out.print(arr[i] + " ");
	}
}