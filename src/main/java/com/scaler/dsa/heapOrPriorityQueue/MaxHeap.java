package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
Heap: Heap is nothing but PriorityQueue in java and it has two properties :
1-Heap should be complete binary tree.
2-it should follow the heap order properties.

Complete Binary Tree: All levels are completely filled except the last level which may be partially filled but filling
must be in left to right order.

Heap order property: They are two types of heap there :
Type-1: Min heap->Node.data<= children at all the nodes.
Type-2: max heap->Node.data>= children at all nodes.


Heap: A binary tree is a heap iff:
1-It is complete binary tree.
2-It follows either min heap property or max heap property.

CBT just needs an array for storage.

				20
			/		\
		   13        6
		   			/  \
		  /  \
		 2	  10   5	4
		/ \
	    0  1 
	    
Array replaces tree here 
A[]={X 20	13	6	2	10	5	4	0	1}
	 0	1	2	3	4	5	6	7	8	9

If levels are completely filled then it will produce an flatten Array
			
				idx parent -> child
				/ \
			2*idx	2*idx+1
Same like that we know the index of child then we can get the index of parent.
 */
public class MaxHeap {
	private ArrayList<Integer> A;
	private int size;
	private int maxsize;

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(15);
		maxHeap.A.add(-1);

		maxHeap.insert(20);
		maxHeap.insert(10);
		maxHeap.insert(15);
		maxHeap.insert(8);
		maxHeap.insert(6);
		maxHeap.insert(7);
		maxHeap.insert(9);
		maxHeap.insert(4);
		maxHeap.insert(3);
		maxHeap.insert(2);
		maxHeap.insert(6);
		maxHeap.insert(100);

		maxHeap.print();
		System.out.println();
		System.out.println(maxHeap.getdMax());
		System.out.println(maxHeap.isEmpty());
		maxHeap.removeMax();
		maxHeap.print();
		System.out.println();
		maxHeap.removeMax();
		maxHeap.print();
	}

	public MaxHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		A = new ArrayList<>(maxsize);
	}

	public void insert(int data) {
		size++;
		int i = size;
		A.add(data);

		while (i > 1 && A.get(i) > A.get(i / 2)) {
			swap(i, i / 2);
			i = i / 2;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getdMax() {
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
			if (left <= size && A.get(left) > A.get(i))
				max = left;
			if (right <= size && A.get(right) > A.get(max))
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
