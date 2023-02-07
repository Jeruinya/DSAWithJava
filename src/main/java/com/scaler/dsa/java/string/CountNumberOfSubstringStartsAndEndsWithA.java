package com.scaler.dsa.java.string;

/*
Problem Description
You are given a string A. Find the number of substrings that start and end with 'a'.

Problem Constraints
1 <= |A| <= 105
The string will have only lower case English letters.

Input Format
Given the only argument is a String A.

Output Format
Return number of substrings that start and end with 'a'.

Input 1: A = "aab"
Input 2: A = "bcbc"

Output 1: 3
Output 2: 0

Explanation 1:
 Substrings that start and end with 'a' are:
    1. "a"
    2. "aa"
    3. "a"

Explanation 2:
 There are no substrings that start and end with 'a'.
 
Approach:
Total number of substring will be n(n+1)/2
so here we have to find all the substrings which starts and ends with a in that case we have to count number of a and then apply formula.
 */
public class CountNumberOfSubstringStartsAndEndsWithA {

	public static void main(String[] args) {
		String A = "baaba";
		System.out.println(solve(A));
		System.out.println(countNumberOfSubstringStartsAndEndsWithAEff(A));

	}

	public static int countNumberOfSubstringStartsAndEndsWithAEff(String A) {
		int count = 0;

		for (int i = 0; i < A.length(); i++)
			if (A.charAt(i) == 'a')
				count++;

		return count * (count + 1) / 2;
	}

	public static int solve(String A) {
		int n = (int) A.length();
		// traverse the string and count the frequency of 'a'
		int count_A = 0;
		for (int i = 0; i < n; i++) {
			if (A.charAt(i) == 'a')
				count_A += 1;
		}
		// return the number of strings that start and end with 'a'
		return (count_A * (count_A + 1)) / 2;
	}
}
