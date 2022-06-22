package com.scaler.dsa.java.hashing;

/*
Find the Union of two arrays-- Union of two arrays is the common elements once
 non common elements.
 */
import java.util.HashSet;

class Union {
	public static void main(String[] args) {
		int A1[] = new int[] { 2, 8, 3, 5, 6 };
		int A2[] = new int[] { 4, 8, 3, 6, 1 };

		HashSet<Integer> hs= unionOfTwoArrays(A1,A2);
		System.out.println(hs);
	}

	private static HashSet<Integer> unionOfTwoArrays(int[] A1, int[]A2) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < A1.length; i++)
			hs.add(A1[i]);
		for (int i = 0; i < A2.length; i++)
			hs.add(A2[i]);
		return hs;
	}
}