package com.scaler.dsa.java.string;

/*
Given s string find longest substring which is palindrome also.

 */
public class LongestSubstringPalindrome {

	public static void main(String[] args) {

		String str = "xbdyzzydbdyzydx";

		int len = longestSubstringpalindromeNaive(str);
		System.out.println(len);

		//String str1 = "abb";
		String len1 = longestSubstringpalindromeEfficient(str);
		System.out.println(len1);

	}

	private static String longestSubstringpalindromeEfficient(String A) {
		String ans = "";
		int n = A.length();
		System.out.println(A.substring(0, 0));

		for (int i = 0; i < n; i++) {
			String str = expand(A, i, i);
			if (str.length() > ans.length())
				ans = str;
		}
		//This loop we are running when two adjacent characters are same
		for (int i = 0; i < n - 1; i++) {
			String str1 = expand(A, i, i + 1);
			if (str1.length() > ans.length())
				ans = str1;
		}

		return ans;
	}

//In case of substring() method startIndex is inclusive and endIndex is exclusive.
//here not taking j-1 because if we take j-1 then it will exclude the j-1 and take from j-2.
// so taking j and it will take all the characters from i+1 to j-1.
	public static String expand(String s, int i, int j) {
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			} else
				return s.substring(i + 1, j);
		}
		return s.substring(i + 1, j);
	}

	// TC O(N^3)
	private static int longestSubstringpalindromeNaive(String str) {
		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if (isPalindrome(str, i, j))
					ans = Math.max(ans, j - i + 1);
			}
		}

		return ans;
	}

	// TC O(N)
	private static boolean isPalindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
