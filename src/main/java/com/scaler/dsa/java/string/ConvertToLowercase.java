package com.scaler.dsa.java.string;

import java.util.Arrays;

public class ConvertToLowercase {

	public static void main(String[] args) {
		char A[] = { 'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y' };

		System.out.println(Arrays.toString(to_lower(A)));

	}

	public static char[] to_lower(char[] A) {
		int n = A.length;
		char s[] = new char[n];
		for (int i = 0; i < n; i++) {
			if (A[i] >= 65 && A[i] <= 90)
				s[i] = (char) (A[i] ^ 32);
			else
				s[i] = A[i];
		}
		return s;
	}

}