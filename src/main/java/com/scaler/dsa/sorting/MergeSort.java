package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Merge sort contains three simple steps:
1- Divide the array into two parts.
2- Run merge sort on smaller arrays(Recursion call)
	mergeSort(A,s,mid)
	mergeSort(A,mid+1,e)
	
3- merge the two parts.

A[]={3,6,2,1,7,5,3}

TC-O(nlogn)
Space-O(n)

 */
public class MergeSort {

	public static void main(String[] args) {
		int A[] = { 3, 6, 2, 1, 7, 5, 3 };
		mergeSort(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));

	}

	private static void mergeSort(int[] A, int s, int e) {

		if (s >= e)
			return;
		int mid = (s + e) / 2;
		mergeSort(A, s, mid);
		mergeSort(A, mid + 1, e);
		merge(A, s, mid, e);

	}

	private static void merge(int[] A, int s, int mid, int e) {
		int temp[] = new int[e - s + 1];
		int i = s;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= e) {
			if (A[i] <= A[j]) {
				temp[k] = A[i];
				i++;
				k++;
			} else {
				temp[k] = A[j];
				j++;
				k++;
			}
		}
		// copy remaining elements
		while (j <= e) {
			temp[k] = A[j];
			j++;
			k++;
		}

		// copy remaining elements
		while (i <= mid) {
			temp[k] = A[i];
			i++;
			k++;
		}

		for (i = s; i <= e; i++)
			A[i] = temp[i-s];

	}

}
