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

Input 1: A = 46
Input 2: A = 11

Output 1: 10
Output 2: 2

Explanation 1:
 Sum of digits of 46 = 4 + 6 = 10

Explanation 2:
 Sum of digits of 11 = 1 + 1 = 2

 */
public class SumOfDigits {

	public static void main(String[] args) {
		int A = 46;
		System.out.println(sumOfDigits(A));
	}

	public static int sumOfDigits(int n) {
		if (n == 0)
			return 0;
		return n % 10 + sumOfDigits(n / 10);
	}
}