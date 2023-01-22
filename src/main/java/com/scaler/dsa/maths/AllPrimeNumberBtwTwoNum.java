package com.scaler.dsa.maths;

public class AllPrimeNumberBtwTwoNum {

	public static void main(String[] args) {
		int a = 2;
		int b = 100;
		printPrime(a, b);
	}

	public static void printPrime(int a, int b) {
		for (int i = a; i <= b; i++) {
			boolean flag = isPrime(i);
			if (flag)
				System.out.print(i + " ");
		}
	}

	public static boolean isPrime(int a) {
		for (int i = 2; i * i <= a; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}
}