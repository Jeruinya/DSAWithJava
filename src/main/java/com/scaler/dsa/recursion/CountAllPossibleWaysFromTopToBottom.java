package com.scaler.dsa.recursion;

/*
The problem is to count all the possible paths from top left to bottom right of a mXn matrix 
with the constraints that from each cell you can either move only to right or down

Examples : 
Input :  m = 2, n = 2;
Output : 2
There are two paths
(0, 0) -> (0, 1) -> (1, 1)
(0, 0) -> (1, 0) -> (1, 1)

Input :  m = 2, n = 3;
Output : 3
There are three paths
(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 */
public class CountAllPossibleWaysFromTopToBottom {

	public static void main(String[] args) {
		int m = 3, n = 3;
		System.out.println(numberofPaths(m, n));
	}

	private static int numberofPaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		 // If diagonal movements are allowed then the last addition is required.
		return numberofPaths(m - 1, n) + numberofPaths(m, n - 1);// + numberOfPaths(m-1, n-1);;
	}

}
