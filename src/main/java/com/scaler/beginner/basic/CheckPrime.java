package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Given an integer A, you have to tell whether it is a
 * prime number or not. A prime number is a natural number greater than 1 which
 * is divisible only by 1 and itself. Problem Constraints 1 <= A <= 106
 */

public class CheckPrime {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		if (a == 1)
			System.out.println("NO");
		else if (a == 2)
			System.out.println("YES");
		else {
			int i = 3;
			for (; i < a; i++) {
				if (a % i == 0) {
					System.out.println("NO");
					break;
				}

			}
			if (a == i)
				System.out.println("YES");
		}

	}
}