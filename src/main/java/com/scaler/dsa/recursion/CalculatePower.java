package com.scaler.dsa.recursion;

public class CalculatePower {

	public static void main(String[] args) {
		int a = 2, n = 2;
		System.out.println(calculatePow(a, n));
		System.out.println(mod(a, n));
		System.out.println(mod1(a, n));

	}

	private static int mod1(int a, int n) {
		if (n == 0)
			return 1;
		if (a == 1)
			return 1;
		int p = mod1(a, n / 2);
		if (n % 2 == 0)
			return p * p;
		else
			return p * p * a;
	}

	private static int mod(int a, int n) {
		if (n == 0)
			return 1;
		if (n % 2 == 0)
			return mod(a, n / 2) * mod(a, n / 2);
		else
			return mod(a, n / 2) * mod(a, n / 2) * a;
	}

	private static int calculatePow(int a, int n) {
		if (n == 0)
			return 1;

		return a * calculatePow(a, n - 1);
	}

}
