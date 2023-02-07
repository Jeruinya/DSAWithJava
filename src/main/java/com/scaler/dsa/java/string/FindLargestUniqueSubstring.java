package com.scaler.dsa.java.string;

import java.util.HashSet;

/*
Problem Description
Given a string A, find the length of the longest substring without repeating characters.
Note: Users are expected to solve in O(N) time complexity.

Problem Constraints
1 <= size(A) <= 106
String consists of lowerCase,upperCase characters and digits are also present in the string A.

Input Format
Single Argument representing string A.

Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.

Input 1: A = "abcabcbb"
Input 2: A = "AaaA"

Output 1: 3
Output 2: 2

Explanation 1:
 Substring "abc" is the longest substring without repeating characters in string A.

Explanation 2:
 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class FindLargestUniqueSubstring {

	public static void main(String[] args) {
		String s = "abcabcdde";
		System.out.println(longestUniqueSubstring(s));
		System.out.println(longestUniqueSubstringEff(s));

	}

	private static int longestUniqueSubstringEff(String A) {
		int i = 0, j = 0, len = 0;
		int n = A.length() - 1;

		HashSet<Character> hs = new HashSet<>();
		while (j <= n) {
			if (!hs.contains(A.charAt(j))) {
				hs.add(A.charAt(j));
				j++;
				len = Math.max(len, hs.size());
			} else {
				hs.remove(A.charAt(i));
				i++;
			}
		}
		return len;
	}

	// Time complexity O(n^3) Space -O(n)
	private static int longestUniqueSubstring(String A) {
		int len = 0;
		int n = A.length();
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				if (areDisting(A.substring(i, j)))
					len = Math.max(len, j - i);

		return len;
	}

	private static boolean areDisting(String A) {

		int[] c = new int[26];
		for (int i = 0; i < A.length(); i++)
			c[A.charAt(i) - 'a']++;

		for (int i = 0; i < 26; i++) {
			if (c[i] > 1)
				return false;
		}

		return true;
	}
}
