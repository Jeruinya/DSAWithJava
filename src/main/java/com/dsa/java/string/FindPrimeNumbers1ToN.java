package com.dsa.java.string;

import java.util.Scanner;

/**
 * Problem Description You are given an integer N you need to print all the
 * Prime Numbers between 1 and N. Prime numbers are numbers that have only 2
 * factors: 1 and themselves. For example, the first 5 prime numbers are 2, 3,
 * 5, 7, and 11.
 */

public class FindPrimeNumbers1ToN {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if (n == 1) {
			System.out.println("No prime number");
		} else if (n == 2) {
			System.out.println(n);
		} else if (n >= 3) {
			for (int i = 2; i <= n; i++) {
				int j = 2;
				for (; j < i; j++) {
					if (i % j == 0)
						break;
				}
				if (i == j)
					System.out.println(i);
			}

		}

	}
}
