package com.scaler.dsa.java.hashing;

import java.util.HashMap;

public class FindFirstRepeatingElementInArray {

	public static void main(String[] args) {
		int A[] = { 10, 5, 3, 4, 3, 5, 6 };
		int res = -1;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);
			else
				hm.put(A[i], 1);
		}
		for (int i = 0; i < A.length; i++) {
			if (hm.get(A[i]) > 1) {
				res = A[i];
				break;
			}
		}

		System.out.println(res);
	}
}
