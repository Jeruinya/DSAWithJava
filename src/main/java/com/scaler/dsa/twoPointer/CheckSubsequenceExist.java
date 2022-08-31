package com.scaler.dsa.twoPointer;

/*
Given two arrays(sorted or unsorted), check if second array is a sunsequence of array one in same order.
 */
public class CheckSubsequenceExist {

	public static void main(String[] args) {
		int A[] = { 3, 5, 7, 10, 14 };
		int B[] = { 3, 10, 14 };
		System.out.println(isSubsequencePresent(A, B));

	}

	private static boolean isSubsequencePresent(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;
		int i = 0;
		int j = 0;
		while (i <= n - 1 && j <= m - 1) {
			if (A[i] != B[j]) {
				i++;
			}else {
				i++;
				j++;
			}
		}
		if (j == m)
			return true;
		return false;
	}

}
