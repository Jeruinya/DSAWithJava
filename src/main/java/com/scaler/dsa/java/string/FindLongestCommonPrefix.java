package com.scaler.dsa.java.string;

/*
Problem Description
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Problem Constraints
0 <= sum of length of all strings <= 1000000
Input Format
The only argument given is an array of strings A.
Output Format
Return the longest common prefix of all strings in A.

Input 1:A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:A = ["abab", "ab", "abcd"];
Output 1:"a"
Output 2:"ab"
Explanation 1:
Longest common prefix of all the strings is "a".
Explanation 2:
Longest common prefix of all the strings is "ab".

String s="abc";
String s1= "abcd";
int d=s.indexOf(s1);  indexOf() method will check whther two strings are equal or not , if equal returns zero else return -1;
 */
public class FindLongestCommonPrefix {

	public static void main(String[] args) {
		String str[] = { "aabcdefgh", "aaefghijk", "aabcefgh" };

		String longestPref = findLongestPrefix(str);
		System.out.println(longestPref);

	}

	private static String findLongestPrefix(String[] A) {
		if (A.length == 0)
			return "";
		String prefix = A[0];
		for (int i = 1; i < A.length; i++)
			while (A[i].indexOf(prefix) != 0)
				prefix = prefix.substring(0, prefix.length() - 1);
		return prefix;
	}

}
