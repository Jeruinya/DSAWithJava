package com.scaler.dsa.recursion;

public class CalculatePower {

	public static void main(String[] args) {
		int a = 2, n = 2;
		int res = calculatePow(a, n);
		System.out.println(res);

		int res1 = calculatePowEfficient(a, n);
		System.out.println(res1);

		int res2 = calculatePowSuperEfficient(a, n);
		System.out.println(res2);

	}

	private static int calculatePowSuperEfficient(int a, int n) {
		if (n == 0)
			return 1;
		if (a == 1)
			return 1;
		int p = calculatePowSuperEfficient(a, n / 2);
		if (n % 2 == 0)
			return p * p;
		else
			return p * p * a;
	}

	private static int calculatePowEfficient(int a, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return calculatePowEfficient(a, n / 2) * calculatePowEfficient(a, n / 2);
		else
			return calculatePowEfficient(a, n / 2) * calculatePowEfficient(a, n / 2) * a;
	}

	private static int calculatePow(int a, int n) {
		if (n == 0)
			return 1;

		return a * calculatePow(a, n - 1);
	}

}
