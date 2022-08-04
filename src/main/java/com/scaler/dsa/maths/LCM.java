package com.scaler.dsa.maths;

/*
Problem Description
You are given two non-negative integers, A and B. Find the value of the Least Common Multiple (LCM) of A and B.
LCM of two integers is the smallest positive integer divisible by both.

An efficient solution is based on the below formula for LCM of two numbers ‘a’ and ‘b’
   a x b = LCM(a, b) * GCD (a, b)
   LCM(a, b) = (a x b) / GCD(a, b)
 */
public class LCM {

	public static void main(String[] args) {
		int a = 15, b = 20;

		System.out.println(lcmNaive(a, b));
		System.out.println(lcmBetter(a, b));
		System.out.println(lcmEfficient(a, b));
	}

	private static int lcmBetter(int a, int b) {
		int large = Math.max(a, b);
		int other = Math.min(a, b);
		int i = large;
		while (true) {
			if (i % other == 0)
				break;
			i = i + large;
		}
		return i;
	}

	private static int lcmEfficient(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int lcmNaive(int a, int b) {
		int i = 1;
		while (true) {
			if (i % a == 0 && i % b == 0)
				break;
			i++;
		}
		return i;
	}

	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

}
