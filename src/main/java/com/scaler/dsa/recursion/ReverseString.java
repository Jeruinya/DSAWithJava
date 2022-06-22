package com.scaler.dsa.recursion;

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
		String str = "Allstate";
		String s = printReverse(str);
		System.out.println(s);

		String res = recursiveRevers(str);
		System.out.println(res);
	}

	public static String printReverse(String str) {
		if (str.length() - 1 <= 0)
			return str;
		return str.charAt(str.length() - 1) + printReverse(str.substring(0, str.length() - 1));
	}

	public static String recursiveRevers(String s) {
		if (s == null || s.length() <= 1)
			return s;
		return recursiveRevers(s.substring(1)) + s.charAt(0);
	}
}