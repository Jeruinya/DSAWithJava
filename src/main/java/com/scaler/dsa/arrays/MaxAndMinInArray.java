package com.scaler.dsa.arrays;

import java.util.Scanner;

public class MaxAndMinInArray {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] < min)
				min = arr[i];
		}

		System.out.println(max + " " + min);
	}
}