package com.scaler.dsa.java.string;

/*
Problem Description
You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.

Problem Constraints
1 <= N <= 106

Input Format
First and only argument is a string A of length N.

Output Format
Return an integer, denoting the period of the string.

Input 1: A = "abababab"
Input 2: A = "aaaa"
Output 1: 2
Output 2: 1

Explanation 1:
 Period of the string will be 2: 
 Since, for all i, A[i] = A[i%2]. 

Explanation 2:
 Period of the string will be 1.
 */
public class PeriodOfString {

	public static void main(String[] args) {
		String A = "abababab";
		System.out.println(solve(A));

	}

	public static int solve(String A) {
		int n = A.length();
		int[] LPS = new int[n];
		LPS[0] = 0;
		for (int i = 1; i < n; i++) {
			int x = LPS[i - 1];
			while (A.charAt(i) != A.charAt(x)) {
				if (x == 0) {
					x = -1;
					break;
				}
				x = LPS[x - 1];
			}
			LPS[i] = x + 1;
		}
		int k = n - LPS[n - 1];
		return k;
	}
}
