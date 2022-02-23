package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description You are given an integer A. You have to tell whether A is
 * divible by both 5 and 11 or not. Problem Constraints 1 <= A <= 10 to the
 * power 9
 */

public class CheckDivisibilityOfNum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if (n >= 1 && n <= 2147483647) {
			if (n % 5 == 0 && n % 11 == 0)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}