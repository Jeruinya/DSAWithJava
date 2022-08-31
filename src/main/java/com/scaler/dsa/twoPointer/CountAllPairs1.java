package com.scaler.dsa.twoPointer;

import java.util.HashMap;

/*
Given and a sorted array of n distinct elements, check if there exists a pair such that a[i]-a[j]=k, and i!=j.

Two pointer is best when array is sorted.
A[]={-3,0,1,3,6,8,11,14,18,25}
 */
public class CountAllPairs1 {

	public static void main(String[] args) {
		int A[] = { -3, 0, 1, 3, 6, 8, 11, 14, 18, 25 };
		int k = 5;
		countPairsHasMap(A, k);

		countPairsTwoPointers(A, k);

	}

	private static void countPairsTwoPointers(int[] A, int k) {
		int n = A.length;
		int i = 0;
		int j = 1;
		while (j < n) {
			if (A[j] - A[i] == k) {
				System.out.println(i + "," + j);
				i++;
				j++;
			}else if (A[j] - A[i] > k) {
				if (i == j)
					j = j + 1;
				i++;
				
			} else
				j++;

		}

	}

	// TC-O(n) Space-O(n)
	private static void countPairsHasMap(int[] A, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int j = A[i] - k;
			if (hm.containsKey(j)) {
				System.out.println(hm.get(j) + "," + i);
				hm.put(A[i], i);
			}

			else
				hm.put(A[i], i);
		}

	}

}
