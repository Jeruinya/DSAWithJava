package com.scaler.dsa.heapOrPriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/*
Problem Description
Given an integer array A of size N.

You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, 
then the integer at index i in B should be -1.

Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103

Input Format
First and only argument is an integer array A.

Output Format
Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.

Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [10, 2, 13, 4]

Output 1: [-1, -1, 6, 24, 60]
Output 2: [-1, -1, 260, 520]

Explanation 1:
 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60

 So, the output is [-1, -1, 6, 24, 60].
 
Explanation 2:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520

 So, the output is [-1, -1, 260, 520].
 
Approach: Use max heap.
1-A max heap will have the largest value at top of it, one the top number is removed , it will the second largest number then if 
removed we will have the third largest number at the top of the max heap.

2-For each index after finding the product of the three largest numbers push them back to max heap.
 */
public class ProductOfThree {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5};
		int res[]=findProductofThree(A);
		System.out.println(Arrays.toString(res));
	}

	//Time complexity O(nlogn)
	//Space O(n)
	public static int[] findProductofThree(int[] A) {
		int n = A.length;
		int res[] = new int[n];
		int k = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	//	PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>((a, b) -> b - a);
		for (int i = 0; i < n; i++) {
			pq.add(A[i]);

			if (i < 2) {
				res[k++] = -1;
			}else {
				int a = pq.poll();
				int b = pq.poll();
				int c = pq.poll();

				pq.add(a);
				pq.add(b);
				pq.add(c);
				res[k++] = a * b * c;
			}
		}
		return res;
	}
}
