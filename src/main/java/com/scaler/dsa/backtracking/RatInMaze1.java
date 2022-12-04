package com.scaler.dsa.backtracking;

/*
Given an 2D matrix of size n*m, you need to find if there is a path from rat to cheese or not. if there is a path then return true
else return false.
Initially the rat is at location (x,y).
	matrix[i][j]=0   path is Open
	matrix[i][j]=1  path is closed 

					(x,y)
				
		(x,y+1)		(x,y-1)		(x-1,y)		(x+1,y)
		right move   left move	up move		down move
		

 */
public class RatInMaze1 {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 0, 0 }, { 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 } };

		System.out.println(isPathExists(mat, mat.length, mat[0].length, 0, 0));

	}

	private static boolean isPathExists(int[][] mat, int n, int m, int x, int y) {
		if (x == n - 1 && y == m - 1)
			return true;
		if (x == -1 || x == n || y == -1 || y == m)
			return false;

		if (mat[x][y] == 1 || mat[x][y] == 2)
			return false;

		mat[x][y] = 2;

		return isPathExists(mat, n, m, x, y + 1) || isPathExists(mat, n, m, x - 1, y)
				|| isPathExists(mat, n, m, x, y - 1) || isPathExists(mat, n, m, x + 1, y);
	}

}
