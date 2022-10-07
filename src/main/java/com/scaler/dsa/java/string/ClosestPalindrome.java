package com.scaler.dsa.java.string;

/*
Problem Description
Groot has a profound love for palindrome which is why he keeps fooling around with strings.
A palindrome string is one that reads the same backward as well as forward.

Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make 
the given string a palindrome by changing exactly one of its character.

Problem Constraints
1 <= N <= 105
Input Format
The first and only argument is a string A.

Output Format
Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. 
Else, it should return the string NO.

Input 1: A = "abbba"
Input 2: A = "adaddb"

Output 1: "YES"
Output 2: "NO"

Explanation 1:
 We can change the character at index 3(1-based) to any other character. The string will be palindromic.

Explanation 2:
 To make the string palindromic we need to change 2 characters.
 
A="abbba"

Here if we compare first and last char then we can see its same , so move to compare next char and if keep traversing like
that then we will reach at b and if we change b with any character then it will be still palindrome and no impact so we can
return YES
Here string length is odd.

A="abccda"  here b and d are not matched so count is one  other than that every char is matching so we can return yes as if
			we change either char we will get palindrome.

A="xyzzyx"  count=0;
So if the length of the string is even and count is zero then we have to make two char change and simply return no.
 */
public class ClosestPalindrome {

	public static void main(String[] args) {
		String A = "abbba";
		System.out.println(solve(A));

	}

	public static String solve(String A) {

		int count = 0;
		int n = A.length();
		int i = 0;
		int j = n - 1;

		while (i < j) {
			if (A.charAt(i) != A.charAt(j))
				count++;
			i++;
			j--;
		}

		return (count == 0 && A.length() % 2 == 1) || (count == 1) ? "YES" : "NO";
	}
}
