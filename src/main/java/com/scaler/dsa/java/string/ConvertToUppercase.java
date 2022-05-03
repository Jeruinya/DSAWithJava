package com.scaler.dsa.java.string;

import java.util.Arrays;

/*
Problem Description
You are given a function to_upper() consisting of a character array A.
Convert each charater of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.
Return the uppercase version of the given character array.

Input 1: A = ['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2: A = ['S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0']

Output 1: ['S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y']
Output 2: ['S', 'C', 'A', 'L', 'E', 'R', '#', '2', '0', '2', '0']
 */
public class ConvertToUppercase {

	public static void main(String[] args) {
		char A[] = { 'S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y' };

		int n = A.length;
		char s[] = new char[n];
		for (int i = 0; i < n; i++) {
			if (A[i] >= 97 && A[i] <= 122)
				s[i] = (char) (A[i] ^ 32);
			else
				s[i] = A[i];
		}
		System.out.println(Arrays.toString(s));

	}

}
