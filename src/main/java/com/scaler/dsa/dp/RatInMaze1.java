package com.scaler.dsa.dp;

public class RatInMaze1 {

	public static void main(String[] args) {
		int maze[][] = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int n = maze.length;
		int m = maze[0].length;
		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				dp[i][j] = -1;

		System.out.println(countNumberOfWayTopDown(0, 0, n, m, maze, dp));

		System.out.println(countNumberOfWayBottomUp(maze));

	}

	private static int countNumberOfWayBottomUp(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][0] = 1;
		for (int j = 0; j < n; j++)
			dp[0][j] = 1;

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

		return dp[m - 1][n - 1];
	}

	private static int countNumberOfWayTopDown(int x, int y, int m, int n, int[][] mat, int[][] dp) {
		if (x == m - 1 && y == n - 1)
			return 1;
		if (x <= m - 1 && y <= n - 1 && mat[x][y] == 2)
			return 0;
		if (x > m || y > n)
			return 0;

		if (dp[x][y] != -1)
			return dp[x][y];

		int w1 = countNumberOfWayTopDown(x, y + 1, m, n, mat, dp);
		int w2 = countNumberOfWayTopDown(x + 1, y, m, n, mat, dp);
		dp[x][y] = w1 + w2;

		return w1 + w2;
	}

}
