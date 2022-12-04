package com.scaler.dsa.dp;

/*
Given a grid of m*n with some values in the cells,find minimum cost to reach point (m-1, n-1) from (0,0). The only
allowed moves are right and down.

		10	2	 6	  10  3
		
		3  -10	 20   51  5
		
		61  43  17   20   6
		
		81   77  10  -8   8
		
By using backtracking we can find all the paths sum one by one and take the minimum one but its an expensive task
and Time complexity is 2^m+n

How we can use DP ?

dp[i][j]-> denotes the minimum cost to reach (i,j) from (0,0)

dp[i][j] = min(dp[i-1][j],dp[i][j-1])_A[i];

*/
public class RatInMaze4 {

	public static void main(String[] args) {
		int A[][] = { { 10, 2, 6, 10, 3 },

				{ 3, -10, 20, 51, 5 },

				{ 61, 43, 17, 20, 6 },

				{ 81, 77, 10, -8, 8 } };
		
		int B[][]= {{1,3,-4},{2,4,3},{1,0,3}};
		

		System.out.println(minCost(A));
		System.out.println(minCost(B));

	}

	private static int minCost(int[][] A) {
		int m = A.length;
		int n = A[0].length;

		int dp[][] = new int[m][n];
		dp[0][0] = A[0][0];

		for (int i = 1; i < m; i++)
			dp[i][0] = dp[i - 1][0] + A[i][0];

		for (int j = 1; j < n; j++)
			dp[0][j] = dp[0][j-1] + A[0][j];

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + A[i][j];

		return dp[m - 1][n - 1];
	}

}
