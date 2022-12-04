package com.scaler.dsa.dp;

/*
Problem Description
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, 
if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? 
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1

Input Format
First and only argument A is a 2D array of size n * m.

Output Format
Return an integer denoting the number of unique paths from (1, 1) to (n, m).

Input 1:
 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:
 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]

Output 1: 2
Output 2: 0

Explanation 1:
 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}  
 So, the total number of unique paths is 2. 

Explanation 2:
 It is not possible to reach (n, m) from (1, 1). So, ans is 0
 */
public class UniquePathsInGrid {

	public static void main(String[] args) {
		int A[][] = { { 0, 1 } };

		int n = A.length;
		int m = A[0].length;
		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++)
				dp[i][j] = -1;

		if (A[n - 1][m - 1] == 1)
			System.out.println(0);
		else
			System.out.println(countNumberOfWayTopDown(0, 0, n, m, A, dp));

	}

	 private static int countNumberOfWayTopDown(int x, int y, int n, int m, int[][] mat, int[][] dp) {
			if (x == n - 1 && y == m - 1)
				return 1;
	        
	        if (x >= n || y >= m || mat[x][y]==1)
				 return 0;
		    

			if (dp[x][y] != -1)
				return dp[x][y];

			int w1 = countNumberOfWayTopDown(x, y + 1, n, m, mat, dp);
			int w2 = countNumberOfWayTopDown(x + 1, y, n, m, mat, dp);
			dp[x][y] = w1 + w2;

			return w1 + w2;
		}
}
