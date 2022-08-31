package com.scaler.dsa.beginner.basic;

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

			boolean flag = isPerfectSquareNaive(a);

			if (flag == true)
				System.out.println("YES");
			else
				System.out.println("NO");

			boolean flag1 = isPerfectSquareEfficient(a);

			if (flag1 == true)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}

	//TC-O(n)
	public static boolean isPerfectSquareNaive(int a) {
		for (int i = 1; i < a; i++) {
			if (i * i == a)
				return true;
		}
		return false;
	}

	//TC-O(root n)
	public static boolean isPerfectSquareEfficient(int a) {
		for (int i = 1; i * i <= a; i++) 
			if (i* i == a)
				return true;
		return false;
	}
}