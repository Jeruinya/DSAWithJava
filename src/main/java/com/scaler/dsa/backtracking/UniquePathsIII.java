package com.scaler.dsa.backtracking;

/*
Problem Description
Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, 
that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2

Input Format
The first argument given is the integer matrix A.

Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over 
every non-obstacle square exactly once.

Input 1:
A = [[1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:
A = [   [0, 1]
        [2, 0]]
Output 1:2
Output 2:0

Explanation 1:
We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Explanation 1:
Answer is evident here.
 */
public class UniquePathsIII {
	static int xx[] = { 1, 0, 0, -1 };
	static int yy[] = { 0, 1, -1, 0 };
	static int ans;

	public static void main(String[] args) {
		int A[][] = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(countValidPath(A));

	}

	private static int countValidPath(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int u = -1;
		int v = -1;
		ans = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1) {
					u = i;
					v = j;
				} else if (A[i][j] == 0)
					count++;
			}
		}
		recur(u, v, count + 1, A);

		return ans;
	}

	private static void recur(int x, int y, int count, int[][] A) {
		if (A[x][y] == 2) {
			if (count == 0) {
				ans++;
			}
			return;

		}
		A[x][y] = -1;
		for (int i = 0; i < 4; i++) {
			int u = x + xx[i];
			int v = y + yy[i];
			if (isValid(u, v, A))
				recur(u, v, count - 1, A);
		}
		A[x][y] = 0;
	}

	private static boolean isValid(int u, int v, int[][] A) {

		return 0 <= u && u < A.length && 0 <= v && v < A[0].length && A[u][v] != -1;
	}
}
