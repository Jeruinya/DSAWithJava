package com.scaler.dsa.java.hashing;

import java.util.Arrays;

public class StringAnagram {

	static final int CHAR = 256;

	static boolean areAnagramNaive(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		char a1[] = s1.toCharArray();
		Arrays.sort(a1);
		s1 = new String(a1);
		char a2[] = s2.toCharArray();
		Arrays.sort(a2);
		s2 = new String(a2);

		return s1.equals(s2);
	}

	static boolean areAnagramEfficient(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		int[] count = new int[CHAR];
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}

		for (int i = 0; i < CHAR; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		String str1 = "abaac";
		String str2 = "aacba";
		if (areAnagramNaive(str1, str2))
			System.out.println("The two strings are" + " anagram of each other");
		else
			System.out.println("The two strings are not" + " anagram of each other");
	}
}
