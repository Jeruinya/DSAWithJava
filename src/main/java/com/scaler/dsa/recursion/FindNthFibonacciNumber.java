package com.scaler.dsa.recursion;

/*
Problem Description
The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
Fn = Fn-1 + Fn-2
Given a number A, find and return the Ath Fibonacci Number using recursion.
Given that F0 = 0 and F1 = 1.

Problem Constraints
0 <= A <= 20

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the Ath term of the sequence.

Input 1: A = 2
Input 2: A = 9

Output 1: 1
Output 2: 34

Explanation 1:
 f(2) = f(1) + f(0) = 1

Explanation 2:
 f(9) = f(8) + f(7) = 21 + 13  = 34

 */
public class FindNthFibonacciNumber {

	public static void main(String[] args) {
		int n =5;
		System.out.println(findNthFibonaccieTerm(n));

	}

	private static int findNthFibonaccieTerm(int n) {
		
		if(n==0)
			return 0;
		else if (n == 1)
			return 0;
		else if(n==2)
			return 1;
		
		return findNthFibonaccieTerm(n - 1) + findNthFibonaccieTerm(n - 2);

	}

}
