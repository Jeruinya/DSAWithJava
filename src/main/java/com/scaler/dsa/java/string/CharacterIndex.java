package com.scaler.dsa.java.string;

public class CharacterIndex {

	public static void main(String[] args) {
		String str = "scaler";
		System.out.println(solve(str));

	}

	public static String solve(String A) {
		String res = "";
		for (int i = 0; i < A.length(); i++) {
			res = res + A.charAt(i) + (A.charAt(i) - 'a') + 1;
		}
		return res;
	}
}
