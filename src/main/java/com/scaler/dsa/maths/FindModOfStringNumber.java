package com.scaler.dsa.maths;
/*
Problem Description
You are given a large number in the form of a string A where each character denotes a digit of the number.
You are also given a number B. You have to find out the value of A % B and return it.

Input Format
The first argument is a string A.
The second argument is an integer B.

Output Format
Return a single integer denoting the value of A % B.

Input 1:A = "143" B = 2
Input 2:A = "43535321", B = 47

Output 1:1
Output 2:20
 */

public class FindModOfStringNumber {

	public static void main(String[] args) {
		String A = "123456678667788975554";
		int B = 18;
		// long strNum = Long.parseLong(A);
		// System.out.println(strNum % B);

		int rem = findMod(A, B);
		System.out.println(rem);

		int rem1 = findModulo(A, B);
		System.out.println(rem1);
	}

	private static int findModulo(String A, int B) {
		long ans = 0, r = 1;
		int n = A.length();
		for (int i = n - 1; i >= 0; i--) {
			  ans=(ans+((A.charAt(i)-'0')*r))%B;
	            r=(r*10)%B;
		}

		return (int) ans % B;
	}

	private static int findMod(String A, int B) {
		long num = 0, rem = 0;
		for (int i = 0; i < A.length(); i++) {
			num = rem * 10 + (A.charAt(i) - '0');
			rem = num % B;
		}
		int remainder = (int) rem;
		return remainder;
	}
}
