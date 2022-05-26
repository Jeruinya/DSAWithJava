package com.scaler.dsa.java.hashing;

import java.util.HashSet;

/*
Problem Description
Given an integer array A containing N distinct integers.
Find the number of unique pairs of integers in the array whose XOR is equal to B.
NOTE: Pair (a, b) and (b, a) is considered to be the same and should be counted once.
Problem Constraints
1 <= N <= 105
1 <= A[i], B <= 107
Input Format
The first argument is an integer array A.
The second argument is an integer B.
Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.

Input 1: A = [5, 4, 10, 15, 7, 6]  B = 5
Input 2: A = [3, 6, 8, 10, 15, 50]  B = 5

Output 1: 1
Output 2: 2
Explanation 1: (10 ^ 15) = 5
Explanation 2: (3 ^ 6) = 5 and (10 ^ 15) = 5 
 */
public class PairWithXOR {

	public static void main(String[] args) {
		int A[] = { 5, 4, 10, 15, 7, 6 };
		int B = 5;
		int count = findNumberOfPairsExistNaive(A, B);
		System.out.println(count);

		int count1 = findNumberOfPairsExistEfficient(A, B);
		System.out.println(count1);
	}

	// Observation:XOR Triangle:if A ^ B = C, then A ^ C = B and B ^ C = A
	// Approach:For every A[i] find whether B^A[i] exists in the array.

	private static int findNumberOfPairsExistEfficient(int[] A, int B) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (hs.contains(A[i] ^ B)) {
				count++;
			}
			hs.add(A[i]);
		}

		return count;
	}

	private static int findNumberOfPairsExistNaive(int[] A, int B) {
		int count = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if ((A[i] ^ A[j]) == B)
					count++;
			}
		}
		return count;
	}

}
