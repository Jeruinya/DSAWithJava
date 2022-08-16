package com.scaler.dsa.sorting;

/*
Problem Description
Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.

Problem Constraints
1 <= length of the array <= 105
-2 * 109 <= A[i] <= 2 * 109

Input Format
The only argument given is the integer array A.

Output Format
Return the number of important reverse pairs in the given array A.

Input 1: A = [1, 3, 2, 3, 1]
Input 2: A = [4, 1, 2]

Output 1: 2
Output 2: 1

Explanation 1:
 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).
 */
public class Reversepairs {

	public static void main(String[] args) {
		int A[] = { 1, 3, 2, 3, 1 };
		System.out.println(countReversePair(A));
		
		int A1[] = { 1, 3, 2, 3, 1 };
		int res=mergesort_and_count(A1,0,A.length-1);
		System.out.println(res);

	}

	public static int countReversePair(int[] A) {

		int n = A.length;
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (A[i] > 2L * (A[j]))
					count++;
		return count;
	}

	public static void merge(int a[], int start, int mid, int end) {
		int n1 = (mid - start + 1);
		int n2 = (end - mid);
		int[] L = new int[n1], R = new int[n2];
		for (int i = 0; i < n1; i++)
			L[i] = a[start + i];
		for (int j = 0; j < n2; j++)
			R[j] = a[mid + 1 + j];
		int i = 0, j = 0;
		for (int k = start; k <= end; k++) {
			if (j >= n2 || (i < n1 && L[i] <= R[j]))
				a[k] = L[i++];
			else
				a[k] = R[j++];
		}
	}

	public static int mergesort_and_count(int a[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			int count = mergesort_and_count(a, start, mid) + mergesort_and_count(a, mid + 1, end);
			int j = mid + 1;
			for (int i = start; i <= mid; i++) {
				while (j <= end && 1l * a[i] > a[j] * 2l)
					j++;
				count += j - (mid + 1);
			}
			merge(a, start, mid, end);
			return count;
		} else
			return 0;
	}
}
