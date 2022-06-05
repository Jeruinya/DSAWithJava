package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class CheckANumInFibbonacciSeries {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		for (int i = 1; i <= n; i++) {
			long t = s.nextLong();
			boolean flag = isFibbonaci(t);
			boolean flag1 = isFibbonaci1(t);

			if (flag == true)
				System.out.println("Yes");

			else
				System.out.println("No");
			
			if (flag1 == true)
				System.out.println("Yes");

			else
				System.out.println("No");

		}

	}

	public static boolean isFibbonaci(long n) {

		return isPerfectSqrt(5 * n * n + 4) || isPerfectSqrt(5 * n * n - 4);
	}

	public static boolean isPerfectSqrt(long n) {
		long s = (long) Math.sqrt(n);
		return (s * s == n);
	}

	public static boolean isFibbonaci1(long A) {
		int n1 = 0, n2 = 1;
		if (A == 0 || A == 1)
			return true;
		for (int i = 0; i <= A; i++) {
			if (n1 == A)
				return true;
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;

		}

		return false;

	}
}
