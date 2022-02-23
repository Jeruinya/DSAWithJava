package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description For a given number A, print its multiplication table
 * having the first 10 multiples. Problem Constraints 1 <= A <= 1000
 */

public class MultiplicationTableForANum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.println(a + " * " + i + " = " + a * i);
		}
	}
}