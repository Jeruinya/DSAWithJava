package com.scaler.dsa.java.string;

import java.util.Scanner;

/**
 * Problem Description
 * You are given a lowercase latin alphabetic character C. You have to tell
 * whether it is a vowel or not.
 * The characters 'a', 'e', 'i', 'o', and 'u' are called vowels.
 */

public class VowelCheck {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i')
			System.out.println(1);
		else
			System.out.println(0);
	}
}
