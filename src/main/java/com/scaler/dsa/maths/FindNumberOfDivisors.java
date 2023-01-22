package com.scaler.dsa.maths;

import java.util.Arrays;

/*
Problem Description
Given an array of integers A, find and return the count of divisors of each element of the array.
NOTE: The order of the resultant array should be the same as the input array.
Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106
Input Format
The only argument given is the integer array A.
Output Format
Return the count of divisors of each element of the array in the form of an array.

Input 1: A = [2, 3, 4, 5]
Input 2: A = [8, 9, 10]

Output 1: [2, 2, 3, 2]
Output 1: [4, 3, 4]

Explanation 1:
 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
 */
public class FindNumberOfDivisors {
	static int S[], SZ, NP = 1001001;

	public static void main(String[] args) {
		int A[] = { 2, 3, 4, 5 };
		int res[] = getAllDivisors(A);
		System.out.println(Arrays.toString(res));

		System.out.println(Arrays.toString(solve(A)));
	}

	public static int[] solve(int[] a) {
		sieve();
		int n = a.length;
		int ans[] = new int[n];
		for (int i = 0; i < n; i++)
			ans[i] = countDivisors(a[i]);
		return ans;
	}

	private static int[] getAllDivisors(int[] A) {
		int n = A.length;
		int res[] = new int[n];
		for (int i = 0; i < n; i++) {
			int count = getDivisor(A[i]);
			res[i] = count;

		}
		return res;
	}

	private static int getDivisor(int n) {
		int count = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i == n)
					count++;
				else
					count = count + 2;
			}
		}
		return count;
	}

	static void sieve() {
		int n = NP;
		S = new int[n];
		for (int i = 1; i < n; i++)
			S[i] = i;
		for (int i = 2; i * i <= n; i++) {
			if (S[i] != i)
				continue;
			for (int j = i * i; j < n; j += i) {
				if (S[j] == j)
					S[j] = i;
			}
		}
	}

	static int countDivisors(int x) {
		// Using prime factorization to get the number of divisors for every integer
		int ans = 1;
		while (S[x] > 1) {
			int cnt = 1, u = S[x];
			while (S[x] == u) {
				cnt++;
				x /= u;
			}
			ans *= cnt;
		}
		return ans;
	}
}
