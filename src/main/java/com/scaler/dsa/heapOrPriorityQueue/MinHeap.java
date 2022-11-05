package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap {

	private ArrayList<Integer> A;
	private int size;
	private int maxsize;

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(15);
		minHeap.A.add(-1);

		minHeap.insert(20);
		minHeap.insert(10);
		minHeap.insert(15);
		minHeap.insert(8);
		minHeap.insert(6);
		minHeap.insert(7);
		minHeap.insert(9);
		minHeap.insert(4);
		minHeap.insert(3);
		minHeap.insert(2);
		minHeap.insert(6);
		minHeap.insert(100);

		minHeap.print();
		System.out.println();
		System.out.println(minHeap.getdMin());
		minHeap.removeMax();
		minHeap.print();
	}

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		A = new ArrayList<>(maxsize);
	}

	public void insert(int data) {
		size++;
		int i = size;
		A.add(data);

		while (i > 1 && A.get(i) < A.get(i / 2)) {
			swap(i, i / 2);
			i = i / 2;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getdMin() {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty.");
		return A.get(1);
	}

	private void swap(int i, int j) {
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
	}

	private void removeMax() {
		swap(size, 1);
		size--;
		int i = 1;
		while (i <= size) {
			int max = i;
			int left = 2 * i;
			int right = 2 * i + 1;
			if (left <= size && A.get(left) < A.get(i))
				max = left;
			if (right <= size && A.get(right) < A.get(max))
				max = right;
			if (max == i)
				break;
			swap(i, max);
			i = max;
		}

	}

	public void print() {

		for (int i = 1; i <= size; i++)
			System.out.print(A.get(i) + " ");
	}

}
