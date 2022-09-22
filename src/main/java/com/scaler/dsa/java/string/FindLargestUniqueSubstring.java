package com.scaler.dsa.java.string;

import java.util.HashSet;

/*
Given a string, find the largest unique substring.
example:
String s= "abcabcdde";
Ans: abcd  len =4
 */
public class FindLargestUniqueSubstring {

	public static void main(String[] args) {
		String s = "abcabcdde";
		System.out.println(longestUniqueSubstring(s));
		System.out.println(longestUniqueSubstringEff(s));

	}

	private static int longestUniqueSubstringEff(String s) {
		int i = 0, j = 0, len = 0;
		int n = s.length() - 1;

		HashSet<Character> hs = new HashSet<>();
		while (j <= n) {
			if (!hs.contains(s.charAt(j))) {
				hs.add(s.charAt(j));
				j++;
				len = Math.max(len, hs.size());
			} else {
				hs.remove(s.charAt(i));
				i++;
			}
		}
		return len;
	}

	// Time complexity O(n^3) Space -O(n)
	private static int longestUniqueSubstring(String str) {
		int len = 0;
		int n = str.length();
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				if (areDisting(str, i, j))
					len = Math.max(len, j - i + 1);

		return len;
	}

	private static boolean areDisting(String str, int i, int j) {

		boolean[] visited = new boolean[26];
		for (int k = i; k <= j; k++) {
			if (visited[str.charAt(k) - 'a'] == true)
				return false;
			visited[str.charAt(k) - 'a'] = true;
		}
		return true;
	}
}
