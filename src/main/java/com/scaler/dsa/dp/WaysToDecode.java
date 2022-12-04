package com.scaler.dsa.dp;

import java.util.Arrays;

/*
Problem Description
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.

Problem Constraints
1 <= length(A) <= 105

Input Format
The first and the only argument is a string A.

Output Format
Return an integer, representing the number of ways to decode the string modulo 109 + 7.

Input 1: A = "12"
Input 2: A = "8"

Output 1: 2
Output 2: 1

Explanation 1:
 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.

Explanation 2:
 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
 
 */
public class WaysToDecode {

	static final int m = 1000000007;

	public static void main(String[] args) {
		String A = "12";
		System.out.println(numDecodings(A));
		System.out.println(numDecodings1(A));

	}

	public static int numDecodings1(String A) {

		int n = A.length();
		int[] dp = new int[n];

		Arrays.fill(dp, -1);

		return rec(n - 1, dp, A);
	}

	private static int rec(int i, int[] dp, String A) {

		if (i < 0)
			return 1;

		if (dp[i] != -1)
			return dp[i] % m;

		int ways = 0;

		if (A.charAt(i) > '0') {
			ways = rec(i - 1, dp, A);
			ways %= m;
		}

		if (isValidTwoDigits(i, A)) {
			ways += rec(i - 2, dp, A);
			ways %= m;
		}

		return dp[i] = ways;
	}

	private static boolean isValidTwoDigits(int index, String A) {
		if (index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7'))
			return true;

		return false;
	}

	private static int numDecodings(String A) {
		int n = A.length();

		long[] dp = new long[n];
		if (A.length() == 1 && A.charAt(0) == '0')
			return 0;

		if (A.charAt(0) == '0')
			return 0;
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			if (A.charAt(i - 1) == '0' && A.charAt(i) == '0') {
				dp[i] = 0;
			} else if (A.charAt(i - 1) == '0' && A.charAt(i) != '0') {
				dp[i] = (dp[i - 1]) % m;
			} else if (A.charAt(i - 1) != '0' && A.charAt(i) == '0') {
				if (A.charAt(i - 1) == '1' || A.charAt(i - 1) == '2') {
					dp[i] = ((i >= 2) ? dp[i - 2] : 1) % m;
				} else {
					dp[i] = 0;
				}
			} else if (A.charAt(i - 1) != '0' && A.charAt(i) != '0') {

				if (Integer.parseInt(A.substring(i - 1, i + 1)) <= 26) {
					dp[i] = (dp[i - 1] + ((i >= 2) ? dp[i - 2] : 1)) % m;
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}
		return (int) (dp[n - 1] % m);
	}
}