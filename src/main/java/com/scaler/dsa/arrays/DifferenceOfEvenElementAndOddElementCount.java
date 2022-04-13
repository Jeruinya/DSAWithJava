package com.scaler.dsa.arrays;

import java.util.Scanner;

/**
 * Problem Description
 * 
 * You are given T(number of test cases) integer arrays. For each array A, you
 * have to find the value of absolute difference between the counts of even and
 * odd elements in the array.
 */

public class DifferenceOfEvenElementAndOddElementCount {
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
			if (evenCount > oddCount)
				System.out.println(evenCount - oddCount);
			else
				System.out.println(oddCount - evenCount);
			t--;
		}

	}
}