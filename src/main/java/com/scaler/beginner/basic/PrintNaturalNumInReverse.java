package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Write a program to print all Natural numbers from N to 1
 * where you have to take N as input from user Problem Constraints 1 <= N <=
 * 10000000
 */

public class PrintNaturalNumInReverse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if (n >= 1 && n <= 10000000) {
			for (int i = n; i >= 1; i--)
				System.out.print(i + " ");
		}
	}
}