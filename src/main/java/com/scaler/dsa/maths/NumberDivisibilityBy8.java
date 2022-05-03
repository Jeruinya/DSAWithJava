package com.scaler.dsa.maths;

/*
Problem Description
You are given a number A in the form of a string. Check if the number is divisible by eight or not.
Return 1 if it is divisible by eight else, return 0.

A number is divisible by 8 if the last three digits are divisible or last three digits are 0.

 */
public class NumberDivisibilityBy8 {

	public static void main(String[] args) {

		String A = "16";
		int ans = 0;
		int n = A.length();
		if (n > 3)
			ans = Integer.parseInt(A.substring(n - 3, n));
		else
			ans = Integer.parseInt(A);
		int res = ans % 8;
		if (res == 0)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
