package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description You are given a positive integer A. You have to print the
 * sum of all odd numbers in the range [1, A]. Problem Constraints 1 <= A <=
 * 1000
 */
public class SumOfOddNaturalNum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int oddSum = 1;
		if (n >= 1 && n <= 1000) {
			for (int i = 2; i <= n; i++)
				if (i % 2 != 0)
					oddSum = oddSum + i;
		}
		System.out.print(oddSum);
	}
}