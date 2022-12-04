package com.scaler.dsa.dp;

/*
Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an
opponent by alternating turns. In each turn, a player selects either the first or last coin from the
row, removes it from the row permanently, and receives the value of the coin. Determine the
maximum possible amount of money we can definitely win if we move first.
Note: The opponent is as clever as the user.

Example:
5, 3, 7 10

A		B
10		7
5		3
---    ----
15		10

8	15	3	7

A		B
7		8
15		3
----------
22		11

						i,j
						
				i+1,j-1		i+2,j		i,j-2
				


 */
public class Game {

	public static void main(String[] args) {
		int A[] = { 8, 15, 3, 7 };
		System.out.println(fun(A, 0, A.length - 1));

	}

	private static int fun(int[] A, int i, int j) {
		if (j == i + 1)
			return Math.max(A[i], A[j]);

		return Math.max(A[i] + Math.min(fun(A, i + 2, j), fun(A, i + 1, j - 1)),
				A[j] + Math.min(fun(A, i, j - 2), fun(A, i + 1, j - 1)));
	}

}
