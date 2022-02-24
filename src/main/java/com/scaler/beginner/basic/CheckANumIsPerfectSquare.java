package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description You are given N positive integers. For each given integer
 * A, you have to tell whether it is a perfect number or not. Perfect number is
 * a positive integer which is equal to the sum of its proper positive divisors.
 */

public class CheckANumIsPerfectSquare {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int sum = 1;
			for (int j = 2; j < a; j++) {
				if (a % j == 0)
					sum = sum + j;
			}
			if (sum == a)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}
}