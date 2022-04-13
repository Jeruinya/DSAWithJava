package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class CheckANumInFibbonacciSeries {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		for (int i = 1; i <= n; i++) {
			long t = s.nextLong();
			boolean flag = isFibbonaci(t);

			if (flag == true)
				System.out.println("Yes");

			else
				System.out.println("No");

		}

	}

	public static boolean isFibbonaci(long n) {

		return isPerfectSqrt(5 * n * n+4) || isPerfectSqrt(5 * n * n - 4);
	}

	public static boolean isPerfectSqrt(long n) {
		long s = (long) Math.sqrt(n);
		return (s * s == n);
	}
}
