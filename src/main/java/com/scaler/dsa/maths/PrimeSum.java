package com.scaler.dsa.maths;

import java.util.Arrays;

/*
Problem Description
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
If there is more than one solution possible, return the lexicographically smaller solution.
If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.

Problem Constraints
4 <= A <= 2*107

Input Format
First and only argument of input is an even number A.

Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.

Example Input: 4
Example Output: [2, 2]

Example Explanation
 There is only 1 solution for A = 4.
 
 Observation:
 if one number is x then other number will be A-x.
 */
public class PrimeSum {

	public static void main(String[] args) {
		int A = 4;
		int res[] = primesum(A);
		System.out.println(Arrays.toString(res));

	}

	public static int[] primesum(int A) {

		int res[] = new int[2];

		for (int i = 2; i <= A; i++) {
			int other = A - i;
			if (isPrime(i) && isPrime(other)) {
				res[0] = i;
				res[1] = other;
				return res;
			}
		}
		return res;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
