package com.scaler.dsa.java.hashing;

/*
Given and array of N elements , find the frequency of each elements given in the array
 */
import java.util.HashMap;
import java.util.Map;

public class CountFreqOfArrayElements {

	public static void main(String[] args) {
		int arr[] = new int[] { 15, 16, 27, 27, 28, 15 };
		int n = arr.length;

		countFreq(arr, n);
	}

	static void countFreq(int A[], int n) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);
			else
				hm.put(A[i], 1);
		}

		for (Map.Entry<Integer, Integer> itr : hm.entrySet())
			System.out.println(itr.getKey() + " " + itr.getValue());
	}
}