package com.dsa.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class OccuringMoreThanNbyKTimesEfficientSol {

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 10, 20, 30, 20, 10, 10 };
		int n = arr.length;
		int k = 2;
		printNByKOccurrences(arr, n, k);
	}

	static void printNByKOccurrences(int arr[], int n, int k) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int x : arr)
			m.put(x, m.getOrDefault(x, 0) + 1);
		for (Map.Entry<Integer, Integer> e : m.entrySet())
			if (e.getValue() > n / k)
				System.out.print(e.getKey() + " ");
	}
}