package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Write a program to input an integer T and then T lines
 * each containing two integers A & B from user and print T lines conatining HCF
 * of two given 2 numbers A and B. Problem Constraints 1 <= T <= 1000 1 <= A,B
 * <= 1000000
 */

public class HCFOfMultipleNum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int result = Math.min(a, b);
			while (result > 0) {
				if (a % result == 0 && b % result == 0)
					break;
				result--;
			}
			System.out.println(result);
		}

	}
}