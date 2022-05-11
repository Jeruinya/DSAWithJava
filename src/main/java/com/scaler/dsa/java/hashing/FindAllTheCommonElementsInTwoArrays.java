package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllTheCommonElementsInTwoArrays {

	public static void main(String[] args) {
		int A[] = { 17, 12, 5, 3, 14, 13, 3, 2 };
		int B[] = { 19, 16, 8, 7, 12, 19, 10, 13, 8, 20, 16, 15, 4, 12, 3, 14, 14 };

		HashMap<Integer, Integer> hma = new HashMap<>();
		List<Integer> l = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			if (hma.containsKey(A[i]))
				hma.put(A[i], hma.get(A[i]) + 1);
			else
				hma.put(A[i], 1);
		}
		for (int i = 0; i < B.length; i++) {
			if (hma.containsKey(B[i]) && hma.get(B[i]) > 0) {
				l.add(B[i]);
				hma.put(B[i], hma.get(B[i]) - 1);
			}
		}

		int arr[] = new int[l.size()];
		arr = l.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
		System.out.println(Arrays.toString(arr));
	}
}
