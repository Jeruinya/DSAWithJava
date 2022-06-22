package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description You are given two integers A and B. You have to find the
 * value of A Power B. NOTE: The value of answer is always less than or equal to
 * 109. Problem Constraints 1 <= A, B <= 1000
 */

public class CalculatePower {

	public static void main(String[] args) {
		long a=2;
		int n=32;
		System.out.println(powerNaive(a, n));
		System.out.println(powerEfficient(a, n));

	}

	//Time complexity O(logn)
	private static long powerEfficient(long a, int n) {
		long res = 1;
		while (n > 0) {
			if (n % 2 != 0) {
				res = res * a;
			}
			a = a * a;
			n = n / 2;
		}
		return res;
	}

	//Theta(n)
	private static long powerNaive(long a, int n) {
		long res = 1;
		while (n > 0) {
			res = res * a;
			n--;
		}
		return res;
	}

}