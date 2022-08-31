package com.scaler.dsa.twoPointer;

import java.util.HashMap;

/*
Given and a sorted array of n distinct elements, check if there exists a pair such that a[i]+a[j]=k, and i!=j.
Two pointer is best when array is sorted.

Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers 
( A[i], A[j] ) such that i != j have sum equal to B.

Input Format
The first argument given is the integer array A.
The second argument given is integer B.
Output Format

Return the number of pairs for which sum is equal to B.
Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9 
1 <= B <= 10^9

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 5
Output 1:  2

Input 2:
    A = [5, 10, 20, 100, 105]
    B = 110
Output 2:   2
 */
public class CountAllPairs2 {

	public static void main(String[] args) {
		int A[] = { 1, 3, 4, 6, 7, 10, 13, 19, 20 };
		int K = 17;
		printPairsNaive(A, K);
		System.out.println("-----------");
		int A1[] = { 3, 6, 4, 1, 7, 8, 4 };
		int K1 = 11;
		printPairsEff(A1, K1);
		System.out.println("-------------------");
		printPairsEfficient(A, K);

	}

	// TC-o(n^2) Space-O(1)
	private static void printPairsNaive(int[] A, int k) {
		int n = A.length;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (A[i] + A[j] == k)
					System.out.println(i + "," + j);

	}

	// TC-O(n) Space-O(n)
	private static void printPairsEff(int[] A, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int j = k - A[i];
			if (hm.containsKey(j)) {
				System.out.println(hm.get(j) + "," + i);
				hm.put(A[i], i);
			}

			else
				hm.put(A[i], i);
		}

	}

	// TC-O(n) Space -O(1)
	private static void printPairsEfficient(int[] A, int k) {
		int i = 0;
		int j = A.length - 1;
		while (i < j) {
			if (A[i] + A[j] == k) {
				System.out.println(i + "," + j);
				i++;
				j--;
			} else if (A[i] + A[j] > k)
				j--;
			else
				i++;
		}
	}

}
