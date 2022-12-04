package com.scaler.dsa.dp;

import java.util.Arrays;

/*
Problem Description
Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.
NOTE: You can only move either down or right at any point in time.

Problem Constraints
1 <= M, N <= 2000
-1000 <= A[i][j] <= 1000

Input Format
First and only argument is a 2-D grid A.

Output Format
Return an integer denoting the minimum sum of the path.

Input 1:
 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Input 2:
 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]


Output 1: 8
Output 2: -1

Explanation 1:
 The path will be: 1 -> 3 -> 2 -> 1 -> 1.

Input 2:
 The path will be: 1 -> -3 -> 5 -> -5 -> 1.
 
Approach:
Let DP[i][j] store the minimum sum of numbers along the path from top left to (i,j). where 0<=i<=n-1 and 0<=j<=m-1.

Basically, DP[i][j] = A[i][j] + min(DP[i-1][j],DP[i][j-1]).

You only need to figure out the base conditions and boundary conditions now.

The answer to the problem would be simply Dp[n-1][m-1]. where n is the no. of rows and m is the no. of columns.
 */
public class MinSumPathInMatrix {

	public static void main(String[] args) {
		int[][] A = { { 1, 3, 2 }, { 4, 3, 1 }, { 5, 6, 1 } };

		int dp[][];

		dp = new int[A.length][A[0].length];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		System.out.println(minSum(0, 0, A.length, A[0].length, A, dp));

	}

	public static int minSum(int i, int j, int m, int n, int[][] grid, int[][] dp) {
		if (i == m - 1 && j == n - 1)
			return grid[i][j];
		
		 if (i >= m || j >= n )
			 return Integer.MAX_VALUE;


		if (dp[i][j] != -1)
			return dp[i][j];

		int down = minSum(i + 1, j, m, n, grid, dp);
		int top = minSum(i, j + 1, m, n, grid, dp);
		dp[i][j] = grid[i][j] + Math.min(top, down);

		return dp[i][j];

	}
}
