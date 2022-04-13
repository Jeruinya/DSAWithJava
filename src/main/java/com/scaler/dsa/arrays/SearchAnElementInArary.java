package com.scaler.dsa.arrays;

import java.util.Scanner;

/**
 * Problem Description
 * 
 * You are given an integer T (number of test cases). You are given array A and
 * an integer B for each test case. You have to tell whether B is present in
 * array A or not.
 */

public class SearchAnElementInArary {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			int n = s.nextInt();

			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = s.nextInt();

			int element = s.nextInt();
			int i = 0;
			for (i = 0; i < n; i++) {
				if (arr[i] == element) {
					System.out.println(1);
					break;
				}
			}
			if (i == n)
				System.out.println(0);
			t--;
		}
	}
}