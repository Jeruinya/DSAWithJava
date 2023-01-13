package com.scaler.dsa.java.sequence;

/*
Problem Description

Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. 
Can you help him?
A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. 
For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".

Problem Constraints
1 <= |A| <= 105
A only contains lowercase alphabets.
Input Format
The first and the only argument of input contains the string, A.
Output Format
Return a string representing the answer.

Input 1: A = "abcdsfhjagj" 
Input 2: A = "ksdjgha" 
Output 1: "aa" 
Output 2: "da" 
Explanation 1:
 "aa" is the lexicographically minimum subsequence from A. 
Explanation 2:
 "da" is the lexicographically minimum subsequence from A. 
 */
public class LittlePonnyAnd2Subsequence {

	public static void main(String[] args) {
		System.out.println(solve("scsecugqsb"));

	}

	public static String solve(String A) {
		int n = A.length();
		char min1 = 'z';
		char min2 = 'z';
		int ind = -1;
		String res = "";
		for (int i = 0; i < n - 1; i++) {
			if (A.charAt(i) < min1) {
				min1 = A.charAt(i);
				ind = i;
			}
		}
		for (int i = ind + 1; i < n; i++) {
			if (A.charAt(i) < min2)
				min2 = A.charAt(i);
		}

		return res = res + min1 + min2;
	}
}
