package com.scaler.dsa.java.string;

/*
Problem Description
Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically 
smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.

Problem Constraints
1 <= N, M <= 100000

Input Format
The first argument is a string A of size N.
The second argument is a string B of size M.

Output Format
Return lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
Input 1:
 A = "abba"
 B = "cdd"
Input 2:
 A = "acd"
 B = "bay"

Output 1: "abbac"
Output 2: "ab"

Explanation 1:
 We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
 The lexicographically smallest string will be "abbac".

Explanation 2:
 We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
 The lexicographically smallest string will be "ab".
 
Approach:
1-The first character of both first and second string will be in the answer string.
2-But how many characters of first string should be appended before taking the first character of the second string?.
3-To get the lexicographically smallest string, we keep appending characters from the first string till the first character 
  is less than the first character of the second string.
4-After that we just add the first character of the second string and we have our answer.

 */
public class SmallestPrefixString {

	public static void main(String[] args) {
		String A = "twvvsl";
		String B = "wtcyawv";

		System.out.println(findStringFormed(A, B));

	}

	private static String findStringFormed(String A, String B) {
		StringBuilder res = new StringBuilder();
		res=res.append(A.charAt(0));

		for (int i = 1; i < A.length(); i++) {
			if (A.charAt(i) >=B.charAt(0))
				break;

			res.append(A.charAt(i));
		}
		res = res.append(B.charAt(0));

		return res.toString();
	}

}
