package com.scaler.dsa.heapOrPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array sort it using heap sort.

Below are the steps to sort it using heap sort:
1- Create a max heap.
2-Sort
	i-Swap A[0] with A[n]
	ii-decrease n by one 
	iii- Heapify

Time complexity:

To create max heap we need O(n) time and sorting will take nlogn time , so total time complexity is O(n+nlogn)=> O(nlogn)
 */
public class HeapSort {

	public static void main(String[] args) {
		int A[] = { 3, 5, 1, 7, 2, 6, 8 };

		// Time Complexity O(NlogN)
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int x : A)
			pq.add(x);

		int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		buildMaxHeap(arr);
		System.out.println(Arrays.toString(arr));// [17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1]

		sortHeap(arr);
		System.out.println(Arrays.toString(arr));// [17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1]
	}

	// Swap first and last elements
	// decrease size by one
	// Heapify
	private static void sortHeap(int[] A) {
		int n = A.length - 1;
		while (n > 0) {
			int temp = A[0];
			A[0] = A[n];
			A[n] = temp;
			n--;
			heapify(A, n, 0);
		}

	}

	// Time Complexity O(n)
	private static void buildMaxHeap(int[] A) {
		int n = A.length;
		int startIndex = (n / 2) - 1;

		for (int i = startIndex; i >= 0; i--) {
			heapify(A, n, i);
		}

	}

	static void heapify(int A[], int N, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < N && A[l] > A[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < N && A[r] > A[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;

			// Recursively heapify the affected sub-tree
			heapify(A, N, largest);
		}
	}

}
