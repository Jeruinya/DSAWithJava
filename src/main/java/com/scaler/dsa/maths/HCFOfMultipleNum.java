package com.scaler.dsa.maths;

/**
 * Problem Description Write a program to input an integer T and then T lines
 * each containing two integers A & B from user and print T lines conatining HCF
 * of two given 2 numbers A and B. Problem Constraints 1 <= T <= 1000 1 <= A,B
 * <= 1000000
 */

public class HCFOfMultipleNum {

	public static void main(String[] args) {

		int A = 18;
		int B = 16;
		System.out.println(getGCDNaive(A, B));
		System.out.println(getGCDEfficient(A, B));
		System.out.println(gcdMoreEfficient(A, B));

	}

	private static int getGCDNaive(int A, int B) {
		int result = Math.min(A, B);
		while (result > 0) {
			if (A % result == 0 && B % result == 0)
				break;
			result--;
		}
		return result;
	}

	// Efficient Solution
	public static int getGCDEfficient(int a, int b) {
		if (a == 0 && b != 0)
			return b;
		else if (b == 0 && a != 0)
			return a;
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

	public static int gcdMoreEfficient(int a, int b) {
		int a1, b1;
		while (a > 0) {
			a1 = b % a;
			b1 = a;
			a = a1;
			b = b1;
		}
		return b;
	}
}