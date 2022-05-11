package com.scaler.dsa.java.string;

import java.util.Arrays;
/*
Problem Description
You are given a string A of size N consisting of lowercase alphabets.
You can change at most B characters in the given string to any other lowercase alphabet 
such that the number of distinct characters in the string is minimized.
Find the minimum number of distinct characters in the resulting string.

Input Format
The first argument is a string A.
The second argument is an integer B.
Output Format
Return an integer denoting the minimum number of distinct characters in the string.
Example Input
A = "abcabbccd"  B = 3
Example Output  2

Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */

public class ChangeCharacter {

	public static void main(String[] args) {
		String A = "abcabbccd";
		int B = 3;

		int res = countNumberOfCharactersNeedsTochange(A, B);
		System.out.println(res);
	}

	private static int countNumberOfCharactersNeedsTochange(String A, int B) {
		int c[] = new int[26];
		for (int i = 0; i < A.length(); i++)
			c[A.charAt(i) - 'a']++;
		Arrays.sort(c);
		for (int i = 0; i < 26; i++) {
			if (c[i] != 0) {
				if (B > 0 && B >= c[i])
					B = B - c[i];
				else
					return 26 - i;
			}
		}
		return 0;

	}
}