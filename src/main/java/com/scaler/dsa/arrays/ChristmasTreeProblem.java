package com.scaler.dsa.arrays;

/**
 * Problem Description You are given an array A consisting of heights of
 * Christmas trees and an array B of the same size consisting of the cost of
 * each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you
 * are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap
 * < Aq < Ar, where p < q < r. The cost of these trees is Bp + Bq + Br.
 * 
 * You are to choose 3 trees such that their total cost is minimum. Return that
 * cost.
 * 
 * If it is not possible to choose 3 such trees return -1.
 * 
 * Input 2:
 A = [1, 6, 4, 2, 6, 9]
 B = [2, 5, 7, 3, 2, 7]
 
 output: 7
 */

public class ChristmasTreeProblem {

	public static void main(String[] args) {

		int A[] = { 1, 3, 5 };
		int B[] = { 1, 2, 3 };
		int n = A.length;
		int final_ans = Integer.MAX_VALUE;
		for (int j = 1; j < n - 1; j++) {
			int temp_sum = B[j];
			int val_i = Integer.MAX_VALUE, val_k = Integer.MAX_VALUE;

			for (int i = j - 1; i >= 0; i--) {
				if (A[i] < A[j] && B[i] < val_i)
					val_i = B[i];
			}

			for (int k = j + 1; k < n; k++) {
				if (A[k] > A[j] && B[k] < val_k)
					val_k = B[k];
			}

			if (val_i != Integer.MAX_VALUE && val_k != Integer.MAX_VALUE) {
				temp_sum += val_i + val_k;
				final_ans = Math.min(final_ans, temp_sum);
			}
		}
		if (final_ans == Integer.MAX_VALUE)
			final_ans = -1;

		System.out.println(final_ans);

	}
}