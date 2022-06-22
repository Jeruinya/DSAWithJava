package com.scaler.dsa.recursion;

/*
Problem Description
The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
Fn = Fn-1 + Fn-2
Given a number A, find and return the Ath Fibonacci Number.
Given that F0 = 0 and F1 = 1.

 */
public class FindNthFibonacciNumber {

	public static void main(String[] args) {
		int n = 8;
		int nthT = findNthFibonaccieTerm(n);
		System.out.println(nthT);

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
