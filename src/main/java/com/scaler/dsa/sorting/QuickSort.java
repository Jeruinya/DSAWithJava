package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Quick sort is also based on divide and conquer algorithm.
It tries to partition the array around a pivot element and recursively sort the two parts.

pivot could be :
	last element of the array.
			or
	first element of the array.
			or
	any random element of the array.
	
A[]={3,8,1,2,5,4}

here pivot is 4
partitioned such that pivot is at correct position.

TC- average case o(nlogn)   and worst case  o(n^2)
Space -Average case O(logn)  and worst case o(n)

 */
public class QuickSort {

	public static void main(String[] args) {
		int A[] = { 3, 6, 2, 1, 7, 5, 3 };
		quickSort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));

	}

	private static void quickSort(int[] A, int s, int e) {
		if (s >= e)
			return;
		int p = partition(A, s, e);
		quickSort(A, s, p - 1);
		quickSort(A, p + 1, e);

	}

	private static int partition(int[] A, int s, int e) {
		int pivot = A[e];
		int i = s - 1;

		for (int j = s; j < e; j++) {
			if (A[j] <= pivot) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}

		int temp = A[i + 1];
		A[i+1] = A[e];
		A[e] = temp;

		return i + 1;
	}

}
