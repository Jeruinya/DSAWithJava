package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description You are given an integer A, you need to find and return
 * the sum of all the even numbers between 1 and A. Even numbers are those
 * numbers that are divisible by 2. Problem Constraints 1 <= N <= 500
 */

public class SumOfEvenNaturalNum {

	public int solve(int a) {
		int sum = 0;
		if (a >= 1 && a <= 500) {
			for (int i = 2; i <= a; i++)
				if (i % 2 == 0)
					sum = sum + i;
		}
		return sum;
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		SumOfEvenNaturalNum sol = new SumOfEvenNaturalNum();
		int sum = sol.solve(a);
	}
}
