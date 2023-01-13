package com.scaler.dsa.arrays;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int A[] = { 10, 10, 20, 20, 30, 30, 40, 40, 50 };

		System.out.println(removeDuplicates(A));
	}

	private static ArrayList<Integer> removeDuplicates(int[] A) {
		ArrayList<Integer> list = new ArrayList<>();
		int res = 1;
		list.add(A[0]);
		for (int i = 1; i < A.length; i++) {
			if (list.get(res - 1) != A[i]) {
				list.add(A[i]);
				res++;
			}
		}
		return list;
	}

}
