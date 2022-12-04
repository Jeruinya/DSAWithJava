package com.scaler.dsa.dp;
/*
Problem Description

Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant 
sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

Problem Constraints
1 <= length of(A) <= 100
Sum of all the elements will not exceed 10,000.

Input Format
First and only argument is an integer array A.

Output Format
Return an integer denoting the minimum number of elements whose sign needs to be flipped.


Input 1: A = [15, 10, 6]
Input 2: A = [14, 10, 4]

Output 1: 1
Output 2: 1

Explanation 1:
 Here, we will flip the sign of 15 and the resultant sum will be 1.

Explanation 2:
 Here, we will flip the sign of 14 and the resultant sum will be 0.
 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
 
 Approach:
 
 Let the sum of all the given elements be S.

This problem can be reduced to a Knapsack problem where we have to fill a Knapsack of capacity (S/2) as 
fully as possible and using the minimum no. of elements. We will fill the Knapsack with the given elements.

Sign of all the elements which come into the knapsack will be flipped. As sum of all the elements 
in the Knapsack will be as close to S/2 as possible, we are indirectly calculating minimum non-negative 
sum of all the elements after flipping the sign. Give it a thought and code your way out!
 */

public class FlipArray {

	static class node {
		int items;
		int weight;

		public node(int a, int b) {
			this.items = a;
			this.weight = b;
		}
	}

	public static void main(String[] args) {
		int A[] = { 15, 10, 6 };
		System.out.println(solve(A));

	}

	public static int solve(final int[] A) {
		node[][] dp = new node[105][10005];
		int n = A.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += A[i];
		for (int i = 0; i < 105; i++)
			for (int j = 0; j < 10005; j++)
				dp[i][j] = new node(0, 0);
		int temp = sum / 2;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= temp; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = new node(0, 0);
				else {
					int prev_items = dp[i - 1][j].items;
					int prev_weight = dp[i - 1][j].weight;
					if (j - A[i - 1] >= 0) {
						int curr_weight = dp[i - 1][j - A[i - 1]].weight + A[i - 1];
						int curr_items = dp[i - 1][j - A[i - 1]].items + 1;

						if ((curr_weight > prev_weight)
								|| ((curr_weight == prev_weight) && (curr_items < prev_items))) {
							dp[i][j] = new node(curr_items, curr_weight);
						} else {
							dp[i][j] = dp[i - 1][j];
						}
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		return dp[n][temp].items;
	}

}
