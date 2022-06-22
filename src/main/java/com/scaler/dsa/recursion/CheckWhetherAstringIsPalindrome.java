package com.scaler.dsa.recursion;

/*
Given a string check whether is palindrome or not using recursion
 */
public class CheckWhetherAstringIsPalindrome {

	public static void main(String[] args) {
		String str = "abacaba";
		int s = 0, e = str.length() - 1;
		boolean b = isPalindrome(str, s, e);
		System.out.println(b);

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
