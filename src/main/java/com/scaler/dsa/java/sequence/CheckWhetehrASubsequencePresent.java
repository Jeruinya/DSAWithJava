package com.scaler.dsa.java.sequence;

/*
Given two strings A and B, find if A is a subsequence of B.
Return "YES" if A is a subsequence of B, else return "NO".
Input Format
The first argument given is the string A.
The second argument given is the string B.
Output Format
Return "YES" if A is a subsequence of B, else return "NO".
Constraints
1 <= lenght(A), length(B) <= 100000
'a' <= A[i], B[i] <= 'z'

Input 1:    A = "bit"      B = "dfbkjijgbbiihbmmt"
Output 1: YES
Input 2:   A = "apple"     B = "appel"
Output 2:    "NO"
 */
public class CheckWhetehrASubsequencePresent {

	public static void main(String[] args) {
		String A = "bit";
		String B = "dfbkjijgbbiihbmmt";
		String res = solve(A, B);
		System.out.println(res);
	}

	public static String solve(String A, String B) {

		if (A.length() > B.length())
			return "NO";

		int k = 0;
		for (int i = 0; i < B.length(); i++) {
			if (k < A.length() && A.charAt(k) == B.charAt(i))
				k++;
		}

		if (A.length() == k)
			return "YES";

		return "NO";
	}
}