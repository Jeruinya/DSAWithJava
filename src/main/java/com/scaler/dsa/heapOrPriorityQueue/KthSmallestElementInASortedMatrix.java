package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Description
Given a sorted matrix of integers A of size N x M and an integer B.
Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.
NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.

Problem Constraints
1 <= N, M <= 500
1 <= A[i] <= 109
1 <= B <= N * M

Input Format
The first argument given is the integer matrix A.
The second argument given is an integer B.

Output Format
Return the B-th smallest element in the matrix.

Input 1:
 A = [ [9, 11, 15],
       [10, 15, 17] ] 
 B = 6
Input 2:
 A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12

Output 1: 17
Output 2: 16

Explanation 1:
 6th smallest element in the sorted matrix is 17.

Explanation 2:
 12th smallest element in the sorted matrix is 16.
 */
public class KthSmallestElementInASortedMatrix {

	public static void main(String[] args) {
		int A[][] = { { 5, 9, 11 }, { 9, 11, 13 }, { 10, 12, 15 }, { 13, 14, 16 }, { 16, 20, 21 } };
		int B = 12;
		System.out.println(solve(A,B));

	}

	public static int solve(int[][] A, int B) {
		int n = A.length;
		int m = A[0].length;

		PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2)->i2-i1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pq.size() < B)
					pq.offer(A[i][j]);
				else {
					if (A[i][j] < pq.peek()) {
						pq.poll();
						pq.offer(A[i][j]);
					}
				}
			}
		}
		return pq.peek();
	}

	public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int k = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(0).size(); j++) {
				pq.add(A.get(i).get(j));
				k++;
			}
		}
		while (k != B) {
			pq.poll();
			k--;
		}
		return pq.peek();

	}
}