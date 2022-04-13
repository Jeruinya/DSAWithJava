package com.scaler.dsa.java.string;

public class AsteriskRemoval {

	public static void main(String[] args) {
		String A = "****abc*nnsg***";
		String s = tripAsterisk(A);
		System.out.println(s);
	}

	private static String tripAsterisk(String A) {
		int n = A.length();
		int start = 0;
		while (start < n && A.charAt(start) == '*') {
			start++;
		}
		if (start == n) {
			return "";
		}
		int end = n - 1;
		while (end >= 0 && A.charAt(end) == '*') {
			end--;
		}
		return A.substring(start, end + 1);
	}

}
