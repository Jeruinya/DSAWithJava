package com.scaler.dsa.recursion;

/*
Given a string check whether is palindrome or not using recursion
 */
public class CheckWhetherAstringIsPalindrome {

	public static void main(String[] args) {
		String s = "abacaba";
		System.out.println(isPalindrome(s, 0, s.length() - 1));

	}

	private static boolean isPalindrome(String str, int s, int e) {
		if (s >= e)
			return true;
		else if (str.charAt(s) != str.charAt(e))
			return false;
		else
			return isPalindrome(str, s + 1, e - 1);
	}
}
