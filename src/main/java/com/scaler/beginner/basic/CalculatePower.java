package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description You are given two integers A and B. You have to find the
 * value of A Power B. NOTE: The value of answer is always less than or equal to
 * 109. Problem Constraints 1 <= A, B <= 1000
 */

public class CalculatePower {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		long pow = 1;
		for (int i = 1; i <= b; i++) {
			pow = pow * a;
		}
		System.out.println(pow);
	}

	public static int power(int n, int m) {

		int res = 1;
		while (m > 0) {
			res = res * n;
			m--;
		}
		return res;
	}
}