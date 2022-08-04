package com.scaler.dsa.maths;

import java.util.Scanner;

public class AllPrimeNumberBtwTwoNum {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		printPrime(a, b);
	}

	public static void printPrime(int a, int b) {
		for (int i = a; i <= b; i++) {
			boolean flag = isPrime(i);
			if (flag)
				System.out.print(i+" ");
		}
	}

	public static boolean isPrime(int a) {
		for (int i = 2; i*i<=a; i++) {
			if (a % i == 0) 
				return false;
		}
		return true;
	}
}