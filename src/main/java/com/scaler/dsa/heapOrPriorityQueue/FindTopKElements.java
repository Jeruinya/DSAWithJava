package com.scaler.dsa.heapOrPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array find the top k elements from the array.

Approaches:
1- Sort the Array and print top k elements
   Time complexity will be O(nlogn)

2-Build max heap and extract k elements
  Time complexity O(n+klogn)

3-Build a min heap of size k using first k elements.
 */
public class FindTopKElements {

	public static void main(String[] args) {
		int A[] = { 10, 2, 39, 90, 122, 80, 50, 20, 43 };
		findTopkUsingMaxHeap(A, 3);
		System.out.println();
		findTopkUsingMinHeap(A, 3);

	}

	// Time-O(klogk+(n-k)logk+k)=> O(nlogk)
	private static void findTopkUsingMinHeap(int[] A, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++)
			pq.add(A[i]);

		for (int i = k; i < A.length; i++) {
			if (A[i] > pq.peek()) {
				pq.poll();
				pq.add(A[i]);
			}
		}
		for (int i = 0; i < k; i++)
			System.out.print(pq.poll() + " ");

	}

	// Time-O(n+klogn)
	private static void findTopkUsingMaxHeap(int[] A, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for (int x : A)
			pq.add(x);
		while (k > 0) {
			System.out.print(pq.poll() + " ");
			k--;
		}
	}

}
