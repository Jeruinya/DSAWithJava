package com.scaler.dsa.dp;

import java.util.Arrays;
/*
Problem Description
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], 
we need to calculate maximum amount that could fit in this quantity.
This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.


Problem Constraints
1 <= A <= 1000
1 <= |B| <= 1000
1 <= B[i] <= 1000
1 <= C[i] <= 1000

Input Format
First argument is the Weight of knapsack A
Second argument is the vector of values B
Third argument is the vector of weights C

Output Format
Return the maximum value that fills the knapsack completely

Input 1:
A = 10
B = [5]
C = [10]

Input 2:
A = 10
B = [6, 7]
C = [5, 5]

Output 1: 5
Output 2:14

Explanation 1:
Only valid possibility is to take the given item.

Explanation 2:
Take the second item twice.
 */
public class UnboundedKnapsack {

	public static void main(String[] args) {
		int weight[] = { 12, 3, 5, 15 };
		int price[] = { 100, 80, 40, 90 };
		int c = 20;
		System.out.println(knapsackBottomUpDP(weight, price, c));
		
		System.out.println(knapsackBottomUpDP1(c,price,weight));

	}
	
	 public static int knapsackBottomUpDP1(int A, int[] B, int[] C) {
	        int W = A;
	        int[] dp = new int[W + 1];
	        Arrays.fill(dp, 0);
	        for (int i = 0; i <= W; i++)
	            for (int j = 0; j < B.length; j++)
	                if (C[j] <= i)
	                    dp[i] = Math.max(dp[i], dp[i - C[j]] + B[j]);
	        return dp[W];
	    }

	private static int knapsackBottomUpDP(int[] weight, int[] price, int C) {
		int n = price.length;
		int dp[][] = new int[n + 1][C + 1];

		// Here i denotes upto length i of items, ith item is placed at index i-1 in
		// which weight and price array
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= C; j++) {

				int exc = dp[i - 1][j];
				// include the current item if weight of item is less than current capacity C
				int inc = 0;
				if (j - weight[i - 1] >= 0)
					inc = price[i - 1] + dp[i][j - weight[i - 1]];

				dp[i][j] = Math.max(inc, exc);

			}
		}
		return dp[n][C];
	}
}
