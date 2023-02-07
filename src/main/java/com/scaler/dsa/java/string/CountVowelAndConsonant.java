package com.scaler.dsa.java.string;

import java.util.Arrays;

public class CountVowelAndConsonant {
	public static void main(String[] args) {
		String str = "#GeeksforGeeks";
		System.out.println(Arrays.toString(count(str)));
		;
	}

	public static int[] count(String A) {
		int count[] = new int[2];
		int vow = 0, con = 0;
		String vowel = "aeiouAEIOU";
		for (int i = 0; i < A.length(); i++) {
			if ((A.charAt(i) >= 65 && A.charAt(i) <= 90) || (A.charAt(i) >= 97 && A.charAt(i) <= 122)) {
				if (vowel.contains(String.valueOf(A.charAt(i))))
					vow++;
				else
					con++;
			}
		}
		count[0] = vow;
		count[1] = con;
		return count;
	}
}
