package com.scaler.dsa.java.hashing;

import java.util.HashMap;

public class FindFirstNonRepeatingElementInArray {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 1, 2, 5 };
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);
			else
				hm.put(A[i], 1);
		}

		for (int i = 0; i < A.length; i++) {
			if (hm.get(A[i]) == 1) {
				System.out.println(A[i]);
				break;
			}
		}
		//System.out.println("There is no non repeating element present in the array");

	}

}
