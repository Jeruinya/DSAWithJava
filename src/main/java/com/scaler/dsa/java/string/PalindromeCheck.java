package com.scaler.dsa.java.string;

public class PalindromeCheck {

	static boolean isPalNaive(String str) {
		StringBuffer rev = new StringBuffer(str);
		rev.reverse();
		return str.equals(rev.toString());
	}

	static boolean isPalEfficient(String str) {

		int begin = 0;
		int end = str.length()-1;
		while (begin < end) {
			if (str.charAt(begin) != str.charAt(end))
				return false;
			begin++;
			end--;
		}
		return true;
	}

	public static void main(String args[]) {
		String str = "abcdcba";
		System.out.println(isPalNaive(str));
		System.out.println(isPalEfficient(str));
	}

}
