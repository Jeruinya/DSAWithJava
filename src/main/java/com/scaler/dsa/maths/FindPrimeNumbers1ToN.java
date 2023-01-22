package com.scaler.dsa.maths;

import java.util.Scanner;

/**
 * Problem Description You are given an integer N you need to print all the
 * Prime Numbers between 1 and N. Prime numbers are numbers that have only 2
 * factors: 1 and themselves. For example, the first 5 prime numbers are 2, 3,
 * 5, 7, and 11.
 */

public class FindPrimeNumbers1ToN {
	public static void main(String[] args) {
		int n = 100;
		printPrime(n);
		System.out.println();
		sieveOfEratosthenes(n);

	}

	// TC-O(n root n)
	private static void printPrime(int n) {
		for (int i = 1; i <= n; i++) {
			boolean flag = isPrime(i);
			if (flag)
				System.out.print(i + " ");
		}

	}

	public static boolean isPrime(int a) {
		if (a == 1)
			return false;
		for (int i = 2; i * i <= a; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

	// TC-O(N log log n)
	public static void sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int i = 2; i * i <= n; i++) {
			// If prime[i] is not changed, then it is a prime
			if (prime[i] == true) {
				// Update all multiples of i
				for (int j = i * i; j <= n; j = j + i)
					prime[j] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				System.out.print(i + " ");
		}

	}
}
