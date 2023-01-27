package com.scaler.dsa.java.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array count number of elements occurring more than n/k times.
 */
public class OccuringMoreThanNbyKTimes {

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 10, 20, 20, 20, 20, 10 };
		int n = arr.length;
		int k = 2;
		printNByKOccurrencesNaive(arr, n, k);
		printNByKOccurrencesEfficient(arr, n, k);
		printNByKOccurrences(arr, n, k);
	}

	static void printNByKOccurrencesNaive(int A[], int n, int k) {
		Arrays.sort(A);
		int i = 1, count = 1;
		while (i < n) {
			while (i < n && A[i] == A[i - 1]) {
				count++;
				i++;
			}
			if (count > n / k)
				System.out.print(A[i - 1] + " ");
			count = 1;
			i++;
		}

	}

	static void printNByKOccurrencesEfficient(int arr[], int n, int k) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int x : arr)
			m.put(x, m.getOrDefault(x, 0) + 1);
		for (Map.Entry<Integer, Integer> e : m.entrySet())
			if (e.getValue() > n / k)
				System.out.print(e.getKey() + " ");
	}

	// This solution is best suitable when n is very large and k is very very small
	static void printNByKOccurrences(int A[], int n, int k) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (hm.containsKey(A[i])) {
				hm.put(A[i], hm.get(A[i]) + 1);
			} else if (hm.size() < k - 1)
				hm.put(A[i], 1);
			else
				for (Map.Entry<Integer, Integer> x : hm.entrySet()) {
					Integer c = x.getValue();
					hm.put(x.getKey(), c - 1);
					if (x.getKey() == 0)
						hm.remove(x.getKey());
				}
		}
		for (Map.Entry<Integer, Integer> x : hm.entrySet()) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (x.getKey() == A[i])
					count++;

			}
			if (count > n / k)
				System.out.print(x.getKey() + " ");
		}
	}

}
