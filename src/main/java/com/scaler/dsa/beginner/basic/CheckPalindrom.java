package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Given an integer A, determine whether it is palindromic
 * or not. A palindrome integer is an integer X for which reverse(X) = X where
 * reverse(X) is X with its digits reversed. For e.g., reverse(123) = 321.
 */

public class CheckPalindrom {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int result = 0;
		for (int i = a; i > 0; i = i / 10) {
			int rem = i % 10;
			result = result * 10 + rem;
		}
		if (result == a)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
