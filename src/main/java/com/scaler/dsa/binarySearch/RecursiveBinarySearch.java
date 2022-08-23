package com.scaler.dsa.binarySearch;

public class RecursiveBinarySearch {

	public static void main(String[] args) {
		int A[] = { 3, 5, 8, 10, 15, 20, 25 };
		int t = 15;
		System.out.println(binarySearch(A, t, 0, A.length - 1));

	}

	private static int binarySearch(int[] A, int t, int s, int e) {
		if (s > e)
			return -1;
		int mid = (s + e) / 2;
		if (A[mid] > t)
			return binarySearch(A, t, s, mid - 1);
		else if (A[mid] == t)
			return A[mid];
		else
			return binarySearch(A, t, mid + 1, e);
	}

}
