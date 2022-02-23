package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Write a program to print all Natural numbers from 1 to N where you have to
 * take N as input from user Problem Constraints 1 <= N <= 10000000
 */

public class PrintNaturalNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		if (n >= 1 && n <= 10000000) {
			for (int i = 1; i <= n; i++)
				System.out.print(i + " ");
		}
	}

}
