package com.scaler.dsa.heapOrPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of N elements build a max heap.
Approach:
1- Create PriorityQueue and put all the array elements one by one .
2-The above approach can be optimized by observing the fact that the leaf nodes need not to be heapified as 
   they already follow the heap property. Also, the array representation of the complete binary tree contains 
   the level order traversal of the tree. So the idea is to find the position of the last non-leaf node and perform 
   the heapify operation of each non-leaf node in reverse level order.

Heapify: Get the left node and right node and which ever is bigger put to top and go up and check same for other nodes.

Last non-leaf node = parent of last-node.
or, Last non-leaf node = parent of node at (n-1)th index.
or, Last non-leaf node = Node at index ((n-1) – 1)/2 = (n/2) – 1.

Note- The purpose of the BST is to search a element faster while heap is used to get max of min element quickly.


 */
public class CreateMaxHeapFromArray {

	public static void main(String[] args) {
		int A[] = { 3, 5, 1, 7, 2, 6, 8 };

		// Time Complexity O(NlogN)
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int x : A)
			pq.add(x);

		int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
		buildMaxHeap(arr);
		System.out.println(Arrays.toString(arr));//[17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1]

	}

	//Time Complexity O(n)
	private static void buildMaxHeap(int[] A) {
		int n = A.length;
		int startIndex=(n/2)-1;
		
		for (int i = startIndex; i >= 0; i--) {
			heapify(A,n, i);
		}

	}
	
	static void heapify(int A[], int N, int i)
    {
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


	private static void heapify(int A[], int i) {
		int size = A.length;
		swap(A, size, i);
		size--;
		
		while (i <= size) {
			int max = i;
			int left = 2 * i;
			int right = 2 * i + 1;
			if (left <= size && A[left] > A[i])
				max = left;
			if (right <= size && A[right] > A[max])
				max = right;
			if (max == i)
				break;
			swap(A, i, max);
			i = max;
		}
	}

	private static void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
