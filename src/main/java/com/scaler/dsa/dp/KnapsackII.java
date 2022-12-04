package com.scaler.dsa.dp;

/*
Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.
Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Problem Constraints
1 <= N <= 500
1 <= C, B[i] <= 106
1 <= A[i] <= 50

Input Format
First argument is an integer array A of size N denoting the values on N items.
Second argument is an integer array B of size N denoting the weights on N items.
Third argument is an integer C denoting the knapsack capacity.

Output Format
Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is 
smaller than or equal to C.

Input 1:
 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50
Input 2:
 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10

Output 1: 22
Output 2: 0

Explanation 1:
 Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22

Explanation 2:
 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
public class KnapsackII {

	public static void main(String[] args) {
		int weight[] = { 12, 3, 5, 15 };
		int price[] = { 100, 80, 40, 90 };
		int c = 20;
		System.out.println(knapsack(price, weight,c));
		System.out.println(solve(price, weight,c));

	}

	private static int knapsack(int[] V,int[] W, int K) {
	    int N = W.length;
	    int[] dp = new int[K + 1];

	    for (int i = 1; i <= N; i++) {
	      for (int j = K; j >= 0; j--) {
	        dp[j] = dp[j];

	        if (j >= W[i - 1]) {
	          dp[j] = Math.max(dp[j], dp[j - W[i - 1]] + V[i - 1]);
	        }
	      }
	    }

	    return dp[K];
	  }
	
	public static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int mxval = 50 * n;
        int[] dp = new int[mxval + 1];
        for (int i = 0; i < mxval + 1; i++) {
            dp[i] = 1000000000;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int val = mxval; val >= A[i]; val--) {
                dp[val] = Math.min(dp[val], B[i] + dp[val - A[i]]);
            }
        }
        int ans = 0;
        for (int val = mxval; val >= 0; val--) {
            if (dp[val] <= C) {
                ans = val;
                break;
            }
        }
        return ans;
    }
}
