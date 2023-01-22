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
		int A = 10;
		System.out.println(Arrays.toString(primesum(A)));
		System.out.println(Arrays.toString(primesumEff(A)));

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

	public static int[] sieve(int N) {
		// Generate isPrime List less equal than N
		int[] sieve = new int[N + 1];
		sieve[0] = 0;
		sieve[1] = 0;
		for (int i = 2; i <= N; i++) {
			sieve[i] = 1;
		}
		// Sieve of Erastothenes
		for (int i = 2; i <= N; i++) {
			if (sieve[i] == 0)
				continue;
			if (i > N / i)
				break;
			for (int j = i * i; j <= N; j += i)
				sieve[j] = 0;
		}
		return sieve;
	}

	public static int[] primesumEff(int A) {
		int[] sieve = sieve(A);
		int[] ans = new int[2];
		for (int i = 2; i <= A; ++i) {
			if (sieve[i] == 1 && sieve[A - i] == 1) {
				ans[0] = i;
				ans[1] = A - i;
				return ans;
			}
		}
		return ans;
	}

}
