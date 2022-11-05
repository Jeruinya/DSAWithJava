package com.scaler.dsa.heapOrPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Description
Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the 
N elements and add the original value(value stored at the index before we did any operations) to its current value. 
You can choose any of the N elements in each operation.

Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.

Problem Constraints
1 <= N <= 106
0 <= B <= 105
-105 <= A[i] <= 105

Input Format
The first argument is an integer array A.
The second argument is an integer B.

Output Format
Return an integer denoting the minimum possible largest element after B operations.

Input 1:
 A = [1, 2, 3, 4] 
 B = 3
Input 2:
 A = [5, 1, 4, 2] 
 B = 5

Output 1: 4
Output 2: 5

Explanation 1:
 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.

Explanation 2:
 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.
 
->Solution Approach:We will take an element which will have minimum possible next state.
->We can use min heap to maintain the next state of all the elements because we want the minimum element every time.

Original state         Current state
A=[5,1,4,2]   			[5,1,4,2]
B=5

		Min heap
		(10,0)
		(2,1)
		(8,2)
		(4,3)
		
Operation-1:
	pop(2,1)
	add(3,1)
Now min heap become:
		Min heap
		(10,0)
		(3,1)
		(8,2)
		(4,3)

Operation-2:
	pop(3,1)
	add(4,1)
Now min heap become:
		Min heap
		(10,0)
		(4,1)
		(8,2)
		(4,3)

Operation-3:
	pop(4,1)
	add(5,1)
Now min heap become:
		Min heap
		(10,0)
		(5,1)
		(8,2)
		(4,3)

Operation-4:
	pop(4,3)
	add(6,3)
Now min heap become:
		Min heap
		(10,0)
		(5,1)
		(8,2)
		(6,3)
		
Operation-5:
	pop(5,1)
	add(6,1)
Now min heap become:
		Min heap
		(10,0)
		(6,1)
		(8,2)
		(6,3)

 */
public class MinimumLargestElement {

	static class Pair {
		int index;
		int val;

		Pair(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int A[] = { 5, 1, 4, 2 };
		int B = 5;
		System.out.println(findMinimumLargestElement(A, B));
		System.out.println(solve(A, B));

	}

	private static int findMinimumLargestElement(int[] A, int B) {
		int max = Integer.MIN_VALUE;
		PriorityQueue<Pair> pq = new PriorityQueue<>((i1, i2) -> i1.val - i2.val);
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
			pq.add(new Pair(i, 2 * A[i]));
		}

		while (B > 0) {
			Pair p = pq.poll();
			max = Math.max(max, p.val);
			pq.add(new Pair(p.index, A[p.index] + p.val));
			B--;
		}
		return max;
	}

	public static int solve(int[] A, int B) {

		PriorityQueue<Pair> pq = new PriorityQueue<>((i1, i2) -> i1.val - i2.val);
		int s = A.length;

		int[] state = new int[s];
		for (int i = 0; i < s; i++) {
			state[i] = A[i];
		}
		for (int i = 0; i < s; i++) {
			pq.offer(new Pair(i,2 * A[i]));
		}
		while (B> 0) {
			Pair top = pq.poll();
			state[top.index] = top.val;
			pq.offer(new Pair( top.index,A[top.index] + top.val));
			B--;
		}

		int mx = state[0];
		for (int i = 0; i < s; i++)
			mx = Math.max(mx, state[i]);
		return mx;
	}
}
