package com.scaler.dsa.heapOrPriorityQueue;

import java.util.PriorityQueue;

/*
Problem Description
Given an array of integers A and an integer B. You must modify the array exactly B number of times. 
In a single modification, we can replace any one array element A[i] by -A[i].
You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.

Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100

Input Format
The first argument given is an integer array A.
The second argument given is an integer B.

Output Format
Return an integer denoting the maximum array sum after B modifications.

Input 1:
 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:
 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10

Output 1: 196
Output 2: 362

Explanation 1:
 Final array after B modifications = [24, 68, 29, -9, 84]

Explanation 2:
 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
 
Approach: Use min heap.
1-insert all the elements in a min heap.
2-Loop B number of times.
3-If minElement <0 -> modify it and push it back to min heap.
4-if minElement>=0:
	Even: Break if number of operations left is even
	Odd: Change minElement to -minElement , push to min heap and break.
5-Sum up all values of min heap.
 */
public class MaximumArraySumAfterBNegations {

	public static void main(String[] args) {
		int A[] = { 24, -68, -29, -9, 84 };
		int B = 4;
		System.out.println(getMaximumSum(A, B));
		
		System.out.println(solve(A, B));

	}

	private static int getMaximumSum(int[] A, int B) {
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) {
			pq.add(A[i]);
		}

		for (int i = 1; i <= B; i++) {
			int min_val = pq.poll();
			min_val = -(min_val);
			pq.add(min_val);
		}

		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		return sum;
	}

	public static int solve(int[] A, int B) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// insert all elements into the queue
		for (int x : A)
			pq.offer(x);

		// perform B modifications

		while (B > 0) {
			// pop minimum lement from the queue
			int x = pq.poll();

			// if minimum element is 0, we will use all remaining opeations on this and the
			// result will be same
			if (x == 0) {
				B = 0;
			}
			// if minimum element is negative, modify the element to -x and push -x to
			// queue.
			else if (x < 0) {
				pq.offer(-x);
			} else {
				// if remaining operations are even, then in one operation we convert x to -x
				// and in another -x to x. So, no change
				// if operations are odd, we will change the number to -x. Set B = 0.
				if (B % 2 == 0) {
					pq.offer(x);
				} else {
					pq.offer(-x);
				}
				B = 0;
				break;
			}

			B--;
		}

		int ans = 0;

		// add all the elements in the queue to the answer
		while (pq.size() > 0) {
			ans += pq.poll();
		}

		return ans;
	}

}
