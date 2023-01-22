package com.scaler.dsa.maths;

import java.util.HashSet;

/*
You have given an array A having N integers. Let say G is the product of all elements of A.
You have to find the number of distinct prime divisors of G.

Input Format
The first argument given is an Array A, having N integers.
Output Format
Return an Integer, i.e number of distinct prime divisors of G.
Constraints
1 <= N <= 1e5
1 <= A[i] <= 1e5
Input:    A = [1, 2, 3, 4]
Output:  2

Explanation:
    here G = 1 * 2 * 3 * 4 = 24
    and distinct prime divisors of G are [2, 3]
    
Hint:
You just have to find the prime divisors of each element of an array and count the distinct prime divisors.
You can use any data structure like set to store distinct elements.
 */
public class DistinctPrimes {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4 };
		System.out.println(findDistinctPrimeFactorsEff(A));

		System.out.println(findDistinctPrimeFactorsNaive(A));
	}

	public static int findDistinctPrimeFactorsEff(int A[]) {
		HashSet<Integer> set = new HashSet<>();
		// int count = 0;
		int max = Integer.MIN_VALUE;
		for (int i : A) {
			if (i > max)
				max = i;
		}
		// Create Sieve array
		int prime[] = new int[max + 1];
		int n = prime.length;
		prime[0] = 1;
		prime[1] = 1;
		for (int i = 2; i * i <= n; i++) {
			if (prime[i] == 0) {
				for (int j = i * i; j < n; j = j + i) {
					prime[j] = 1;
				}
			}
		}
		// find prime factors and add it to set
		for (int num : A) {
			for (int i = 1; i <= n / i; i++) {
				if (num % i == 0) {
					if (prime[i] == 0)
						set.add(i);
					if (prime[num / i] == 0)
						set.add(num / i);
				}
			}
		}
		return set.size();
	}

	// TLE
	// TC-O(N^2)
	public static int findDistinctPrimeFactorsNaive(int[] A) {
		HashSet<Integer> set = new HashSet<>();

		int n = A.length;
		for (int i = 0; i < n; i++) {
			findPrimeDivisors(A[i], set);
		}
		return set.size();
	}

	public static void findPrimeDivisors(int A, HashSet<Integer> set) {
		for (int i = 2; i <= A; i++) {
			while (A % i == 0) {
				set.add(i);
				A = A / i;
			}
		}
	}
}
