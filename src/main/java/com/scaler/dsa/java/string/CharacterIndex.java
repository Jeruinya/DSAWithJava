package com.scaler.dsa.java.string;

public class CharacterIndex {

	public static void main(String[] args) {
		String str = "scaler";
		String res = solve(str);
		System.out.println(res);

	}

	public static String solve(String A) {
		String res = "";
		for (int i = 0; i < A.length(); i++) {
			// char c= A.charAt(i);
			// int ascii=(int)c;
			res = res + A.charAt(i) + (A.charAt(i) - 'a' + 1);
		}
		return res;
	}
}
