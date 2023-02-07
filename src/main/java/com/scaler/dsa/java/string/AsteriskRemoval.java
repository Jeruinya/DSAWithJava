package com.scaler.dsa.java.string;

/*
Problem Description
You are given a character string A. You to trim(remove) both leading and trailing asterisk characters('*') 
in the string and return the resultant string.

Problem Constraints
1 <= |A| <= 105
A[i] ∈ ['a'-'z', '*']

Input Format
First and only argument is a character string A.

Output Format
Return a character string denoting the resultant string after trimming.

Input 1:A = "**h*e*l*lo*"
Input 2:A = "noasteriskhere"

Output 1:h*e*l*l*o
Output 2:noasteriskhere

Explanation 1:
 The string has 2 leading '*' and 1 trailing '*'. Removing them, the string becomes "hello".

Explanation 2:
 As there are no leading or trailing zeros, resultant string is same as before.
 */
public class AsteriskRemoval {

	public static void main(String[] args) {
		String A = "****abc*nnsg***";
		System.out.println(tripAsterisk(A));
	}

	private static String tripAsterisk(String A) {
		int n = A.length();
		int start = 0;
		while (start < n && A.charAt(start) == '*') {
			start++;
		}
		if (start == n) {
			return "";
		}
		int end = n - 1;
		while (end >= 0 && A.charAt(end) == '*') {
			end--;
		}
		return A.substring(start, end + 1);
	}

}
