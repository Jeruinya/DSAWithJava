package com.scaler.dsa.recursion;

/*
Problem Description
Write a program to find the factorial of the given number A using recursion.

Problem Constraints
0 <= A <= 12
Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the factorial of the number A.

Input 1: A = 4
Input 2: A = 1

Output 1: 24
Output 2: 1

Explanation 1:
 Factorial of 4 = 4 * 3 * 2 * 1 = 24

Explanation 2:
 Factorial of 1 = 1
 */
public class FindFactorialOfANumber {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(fact(n));

	}

	private static int fact(int n) {
		if (n == 1)
			return 1;
		return (fact(n - 1) * n);
	}

}
