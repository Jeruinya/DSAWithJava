package com.scaler.arrays;

import java.util.Scanner;

/**
 * Problem Description You are given an integer T denoting the number of test
 * cases. For each test case, you are given an integer array A. You have to put
 * the odd and even elements of array A in 2 separate arrays and print the new
 * arrays. NOTE: Array elements should have the same relative order as in A.
 */

public class PrintOddAndEvenElements {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			int n = s.nextInt();

			int arr[] = new int[n];

			for (int i = 0; i < n; i++)
				arr[i] = s.nextInt();

			int evenCount = 0, oddCount = 0;
			// int i=0;
			for (int i = 0; i < n; i++) {
				if (arr[i] % 2 == 0)
					evenCount++;
				else
					oddCount++;
			}

			int arrEven[] = new int[evenCount];
			int arrOdd[] = new int[oddCount];
			int count = 0, count1 = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] % 2 == 0)
					arrEven[count++] = arr[i];
				else
					arrOdd[count1++] = arr[i];
			}

			for (int i = 0; i < arrOdd.length; i++)
				System.out.print(arrOdd[i] + " ");
			System.out.println();

			for (int i = 0; i < arrEven.length; i++)
				System.out.print(arrEven[i] + " ");
			System.out.println();
			t--;
		}

	}
}