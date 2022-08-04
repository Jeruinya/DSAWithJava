package com.scaler.dsa.maths;

/**
 * Problem Description Given an integer A, you have to tell whether it is a
 * prime number or not. A prime number is a natural number greater than 1 which
 * is divisible only by 1 and itself. Problem Constraints 1 <= A <= 106
 */

public class CheckPrime {
	public static void main(String[] args) {
		int a = 100;
		boolean flag = isPrime(a);
		System.out.println(flag);
		System.out.println(isPrimeEfficient(a));

	}

	// TC- O(N)
	public static boolean isPrime(int a) {
		for (int i = 2; i <= a - 1; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}

	// TC- O(Root N)
	public static boolean isPrimeEfficient(int n) {

		boolean isPrime = true;
		for (int i = 2; i * 1 <= n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}