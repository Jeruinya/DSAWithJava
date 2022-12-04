package com.scaler.dsa.backtracking;

/*
Given a 2D matrix, find number of ways to reach a cell where the cheese is there. Rat is there at (0,0) index and cheese is at m-1,n-1.
There are some blocked cell also and rat can move into right and down direction only.
 */
public class RatInMaze2 {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0 }, { 2, 0, 0 }, { 2, 2, 0 } };
		System.out.println(countWaysRec(0, 0, mat.length, mat[0].length, mat));

		System.out.println(countWaysIterative(mat));

	}

	private static int countWaysIterative(int[][] mat) {

		int n = mat.length;
		int m = mat[0].length;
		mat[0][0]=0;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (mat[i][j] == 2) {
					mat[i][j] = 0;
				} else {
					mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
				}
			}
		}
		return mat[n - 1][m - 1];
	}

	private static int countWaysRec(int x, int y, int m, int n, int[][] mat) {
		if (x == m - 1 && y == n - 1)
			return 1;
		if (x <= m - 1 && y <= n - 1 && mat[x][y] == 2)
			return 0;
		if (x > m || y > n)
			return 0;

		int w1 = countWaysRec(x, y + 1, m, n, mat);
		int w2 = countWaysRec(x + 1, y, m, n, mat);
		return w1 + w2;
	}

}
