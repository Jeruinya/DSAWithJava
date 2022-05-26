package com.scaler.dsa.recursion;

import java.util.Scanner;

/*
Problem Description
Write a recursive function that, given a string S, prints the characters of S in reverse order.
Problem Constraints
1 <= |s| <= 1000
Input Format
First line of input contains a string S.
Output Format
Print the character of the string S in reverse order.

Input 1: scaleracademy
Input 2: cool
Output 1: ymedacarelacs
Output 2: looc
Explanation 1: Print the reverse of the string in a single line.
 */
public class ReverseString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		printReverse(str);
	}

	public static void printReverse(String str) {
		if (str.length() - 1 <= 0)
			System.out.print(str);
		else {
			System.out.print(str.charAt(str.length() - 1));
			printReverse(str.substring(0, str.length() - 1));
		}
	}
}