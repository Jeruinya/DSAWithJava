package com.scaler.dsa.bitManipulation;

/*
Problem Description
We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. 
The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2,..., AN. 
Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 231 - 1
Input Format
The first and only argument of input contains a single integer array A.
Output Format
Return a single integer denoting the sum.

Input 1: A = [1, 3, 5]
Input 2: A = [2, 3]

Ouptut 1: 8
Output 2: 2

Explanation 1:

 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5) 
 = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
Explanation 2:

 f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2
 */
public class DifferentBitsSumPairwise {

	public static void main(String[] args) {
		int A[] = { 1, 3, 5 };
		System.out.println(cntBits(A));
		System.out.println(sumBitDiff(A));

	}

	static int sumBitDiff(int[] arr) {
		int diff = 0; // hold the ans

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {

				// XOR toggles the bits and will form a number that will have
				// set bits at the places where the numbers bits differ
				// eg: 010 ^ 111 = 101...diff of bits = count of 1's = 2

				int xor = arr[i] ^ arr[j];
				int count = countSetBits(xor); // Integer.bitCount() can also be used

				// when i == j (same numbers) the xor would be 0,
				// thus our ans will remain unaffected as (2*0 = 0)
				diff += 2 * count;
			}
		}

		return diff;
	}

	// Kernighan algo
	static int countSetBits(int n) {
		int count = 0; // `count` stores the total bits set in `n`

		while (n != 0) {
			n = n & (n - 1); // clear the least significant bit set
			count++;
		}

		return count;
	}

	public static int cntBits(int[] A) {
		long ans = 0;
		long mod = 1000000007;

		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & (1 << i)) > 0)
					count++;
			}
			ans = ans + 2L * count * (A.length - count);
			ans = ans % mod;
		}

		return (int) ans;
	}

}
