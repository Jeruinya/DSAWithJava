package com.scaler.dsa.java.string;

/*
Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.

Problem Constraints  :1 <= |A| <= 10^5

String A consist only of lowercase characters.
Input Format
First and only argument is a string A.
Output Format
Return a string denoting the reversed string.

Input 1: A = "scaler"
Input 2: A = "academy"
Output 1: "relacs"
Output 2: "ymedaca"
 */
public class ReversingString {

	public static void main(String[] args) {
		String A = "scaler";
		String res = reverseStringNaive(A);
		System.out.println(res);

		String A1 = "relacs";
		String res1 = reverseStringEfficient(A1);
		System.out.println(res1);
	}

	private static String reverseStringEfficient(String A) {
		StringBuilder sb = new StringBuilder(A);
		int start = 0;
		int end = A.length() - 1;
		while (start < end) {
			sb.setCharAt(start, A.charAt(end));
			sb.setCharAt(end, A.charAt(start));
			start++;
			end--;
		}
		return sb.toString();
	}

	// TC O(N)
	private static String reverseStringNaive(String A) {
		String s = "";
		for (int i = A.length() - 1; i >= 0; i--)
			s = s + A.charAt(i);
		return s;
	}
}