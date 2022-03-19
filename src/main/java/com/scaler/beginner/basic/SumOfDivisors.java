package com.scaler.beginner.basic;

import java.util.Scanner;

public class SumOfDivisors {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		System.out.println(sumOfDivisorsNaive(n));
		System.out.println(sumOfDivisorsEfficientSol(n));

	}

	private static int sumOfDivisorsEfficientSol(int n) {
		int sum = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i == n) {
					sum = sum + i;
				} else {
					sum = sum + i + n / i;
				}
			}
		}
		return sum;
	}

	private static int sumOfDivisorsNaive(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++)
			if (n % i == 0)
				sum = sum + n / i;

		return sum;
	}

}