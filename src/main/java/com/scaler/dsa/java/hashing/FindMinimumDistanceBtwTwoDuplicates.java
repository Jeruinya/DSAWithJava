package com.scaler.dsa.java.hashing;

import java.util.HashMap;

/*
Given an array of size N, return the minimum distance between two duplicate elements.
A[] = {1, 2, 3, 2 ,1 ,2 ,1 ,3 ,2}


 */
public class FindMinimumDistanceBtwTwoDuplicates {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 2, 1, 2, 1, 3, 2 };
		System.out.println(findMinDistanceNaive(A));

		System.out.println(findMinDistanceEff(A));

	}

	private static int findMinDistanceEff(int[] A) {
		int n = A.length;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int s = 0, e = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (hm.containsKey(A[i])) {
				s = hm.get(A[i]);
				e = i;
				min = Math.min(min, e - s);
			} else
				hm.put(A[i], i);
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private static int findMinDistanceNaive(int[] A) {
		int n = A.length;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (A[i] == A[j])
					min = Math.min(j - i, min);

		return min == Integer.MAX_VALUE ? -1 : min;
	}

}
