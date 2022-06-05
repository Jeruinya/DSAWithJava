package com.scaler.dsa.java.sequence;

/*
Given array of n distinct elements,consider all the subsequences of n elements. Find the sum of all these subsequences.
 */
public class FindSumofAllSubsequences {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3 };
		printSubsequences(A);
	}

	private static void printSubsequences(int[] A) {
		int n = A.length;
		for (int i = 0; i < Math.pow(2, n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0)
					sum = sum + A[j];
			}
			System.out.print(sum + " ");
		}
	}
}