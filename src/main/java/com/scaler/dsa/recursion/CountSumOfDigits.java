package com.scaler.dsa.recursion;

/*
Problem Description
Given a number A, we need to find the sum of its digits using recursion.

Problem Constraints
1 <= A <= 109

Input Format
The first and only argument is an integer A.
Output Format
Return an integer denoting the sum of digits of the number A.

 */
public class CountSumOfDigits {

	public static void main(String[] args) {
		int A = 46;
		int res = sumOfDigits(A);
		System.out.println(res);
	}

	public static int sumOfDigits(int n) {
		if (n == 0)
			return 0;
		return n % 10 + sumOfDigits(n / 10);
	}
}