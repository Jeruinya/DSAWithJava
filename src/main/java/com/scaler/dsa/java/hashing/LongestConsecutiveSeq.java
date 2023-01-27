package com.scaler.dsa.java.hashing;

import java.util.Arrays;
import java.util.HashSet;

/*
Given an array of n elements, find the longest consecutive sequence.
Need to find the longest consecutive sequence in the form of x,x+1,x+2....x+i with elements appearing in any order 
Here we are using hashing to find the longest consecutive sequence
 */
public class LongestConsecutiveSeq {

	public static void main(String[] args) {
		int A[] = new int[] { 1, 9, 3, 4, 2, 10, 13 };
		System.out.println(findLongest(A));
	}

	static int findLongest(int A[], int n) {
		Arrays.sort(A);
		int res = 1, count = 1;
		for (int i = 1; i < n; i++) {
			if (A[i] == A[i - 1] + 1)
				count++;
			else {
				res = Math.max(res, count);
				count = 1;
			}
		}
		res = Math.max(res, count);
		return res;
	}

	static int findLongest(int A[]) {
		int n = A.length;

		HashSet<Integer> hs = new HashSet<Integer>();
		int res = 0;

		for (int i = 0; i < n; i++)
			hs.add(A[i]);

		for (int i = 0; i < n; i++) {
			if (!hs.contains(A[i] - 1)) {
				int count = 1;
				while (hs.contains(count + A[i]))
					count++;
				res = Math.max(res, count);
			}
		}
		return res;
	}
}