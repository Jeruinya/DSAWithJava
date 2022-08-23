package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Given an unsorted array of n distinct elements. find the kth element if the array was sorted. indexing is 0-based
 */
public class FindKthElementInUnsortedArrayAfterSorting {

	public static void main(String[] args) {
		int A[] = { 2, 8, 3, 11, 14 };
		int k = 2;
		System.out.println(findKthElement(A, k));

		int A1[] = { 2, 8, 3, 11, 14 };
		int k1 = 2;
		System.out.println(findKthElementEff(A1, k1));

	}

	private static int findKthElementEff(int[] A, int k) {
		int n = A.length;
		int min = A[0];
		int max = A[0];
		for (int i = 1; i < n; i++)
			if (A[i] < min)
				min = A[i];

		for (int i = 1; i < n; i++)
			if (A[i] > max)
				max = A[i];

		int s = min;
		int e = max;
		int ans = 0;

		while (s <= e) {
			int mid = (s + e) / 2;

			int count = countLess(A, mid);
			if (count < k)
				s = mid + 1;
			else if (count >= k) {
				ans = mid;
				e = mid - 1;
			} 
		}
		return ans;
	}

	private static int countLess(int[] A, int mid) {
		int count = 0;
		for (int i = 0; i < A.length; i++)
			if (A[i] < mid)
				count++;
		return count;
	}

	// TC -o(nlogn)
	private static int findKthElement(int[] A, int k) {
		Arrays.sort(A);
		return A[k];
	}

}
