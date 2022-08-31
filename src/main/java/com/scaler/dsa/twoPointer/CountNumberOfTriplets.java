package com.scaler.dsa.twoPointer;

import java.util.Arrays;

/*
Given an array of N elements, count number of triplets such that A[i]+A[j]+A[k]<=T and i<j<k.
A={1,3,2,0,5,7,11}

 */
public class CountNumberOfTriplets {

	public static void main(String[] args) {
		int A[] = { 1, 3, 2, 0, 5, 7, 11 };
		int t = 8;
		System.out.println(countTripletsNaive(A, t));
		System.out.println(countTripletsEfficient(A, t));

	}

	//TC-O(n^2) Space-O(1)
	private static int countTripletsEfficient(int[] A, int T) {
		int n = A.length;
		Arrays.sort(A);
		int count = 0;
		for (int i = 0; i <= n - 3; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				if (A[j] + A[k] > T - A[i])
					k--;
				else {
					count = count + (k - j);
					j++;
				}
			}
		}
		return count;
	}

	// TC-O(n^3) Space -O(1)
	private static int countTripletsNaive(int[] A, int t) {
		int count = 0;
		int n = A.length;
		for (int i = 0; i <= n - 3; i++)
			for (int j = i + 1; j <= n - 2; j++)
				for (int k = j + 1; k <= n - 1; k++)
					if (A[i] + A[j] + A[k] <= t)
						count++;
		return count;
	}

}
