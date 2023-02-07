package com.scaler.dsa.java.string;

/*
Problem Description
Given a string A of size N consisting only of lower case alphabets. The only operation allowed is to insert characters in 
the beginning of the string.
Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.

Problem Constraints
1 <= N <= 106
Input Format
The only argument given is a string A.

Output Format
Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a 
palindrome string.

Input 1: A = "abc"
Input 2: A = "bb"

Output 1: 2
Output 2: 0

Explanation 1:
 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".

Explanation 2:
 There is no need to insert any character at the beginning as the string is already a palindrome. 
 
Brute Force approach:
Start checking the string each time if it is palindrome or not. And if it is not palindrome then delete the last character,
do count++ and check again until string become palindrome. 
Finally return the count which means if count number of characters added at starting it will become palindrome.

Optimized Approach:

String S= "bababaa"
Concatenate  the string with its reverse that is S+"$"+ reverse of S

Text= b a b a b a a $ a a b a b a b
LPS	  0 0 1 2 3 4 0 0 0 0 1 2 3 4 5

Last index if the LPS array will give how many characters of starting index matches with end.
 */
public class MakeStringPalindrome {

	public static void main(String[] args) {
		String A = "bababaa";
		System.out.println(solve(A));
	}

	public static int solve(String A) {
		StringBuilder s = new StringBuilder(A);
		String finalText = A + "$" + s.reverse();

		int n = finalText.length();

		int lps[] = new int[n];
		fillLPS(finalText, lps);


		return A.length()-lps[n-1];
	}

	static void fillLPS(String S, int[] lps) {
		int n = S.length();
		for (int i = 1; i < n; i++) {
			int x = lps[i - 1];
			while (S.charAt(x) != S.charAt(i)) {
				if (x == 0) {
					x = -1;
					break;
				}
				x = lps[x - 1];
			}
			lps[i] = x + 1;

		}
	}
}
