package com.scaler.dsa.java.string;

public class FindLengthOfStringWithoutLibraryFun {

	public static void main(String[] args) {
		String str = "Welcome";
		System.out.println(lengthOfString(str));
		System.out.println(lengthOfString1(str));

	}

	private static int lengthOfString1(String str) {
		int i = 0;
		try {
			for (i = 0;; i++) {
				str.charAt(i);
			}

		} catch (Exception e) {

		}
		return i;
	}

	private static int lengthOfString(String A) {
		int count = 0;
		for (char i : A.toCharArray())
			count++;
		return count;
	}

}
