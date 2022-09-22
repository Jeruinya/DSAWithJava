package com.scaler.dsa.java.string;

/*
Given an integer N, the task is to generate a string str which contains maximum possible lowercase alphabets 
with each of them appearing an odd number of times.

Input: N = 17 
Output: bcdefghijklmnopqr 
Explanation: In order to maximize the number of characters, any 17 characters can be selected and made to appear once. 
Thus, abcdefghijklmnopq, bcdefghijklmnopqx, etc can be also be valid outputs.
 */
public class GenerateOddOccurrenceString {

	public static void main(String[] args) {
		int n = 35;
		System.out.println(generateOddOccurrenceString(n));
		System.out.println(generateTheString(n));
	}

	private static String generateOddOccurrenceString(int n) {
		String ans = "";
		if (n % 2 != 0) {
			for (int i = 0; i < Math.min(n, 24); i++)
				ans = ans + (char) ('b' + i);
			if (n > 24) {
				for (int i = 0; i < n - 24; i++)
					ans = ans + 'a';
			}
		} else {
			for (int i = 0; i < Math.min(n, 25); i++)
				ans = ans + (char) ('b' + i);
			if (n > 25) {
				for (int i = 0; i < n - 25; i++)
					ans = ans + 'a';
			}
		}
		return ans;
	}

	public static String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();
		if (n % 2 == 0) {
			sb.append('a');
			for (int i = 0; i < n - 1; i++) {
				sb.append('b');
			}
		} else {
			for (int i = 0; i < n; i++) {
				sb.append('a');
			}
		}
		return sb.toString();
	}

}
