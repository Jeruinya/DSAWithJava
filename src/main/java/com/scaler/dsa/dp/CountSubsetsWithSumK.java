package com.scaler.dsa.dp;

/*
Given an array A[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

Examples: 
A[] = {1, 2, 3, 3}, X = 6 

Output: 3 
All the possible subsets are {1, 2, 3}, 
{1, 2, 3} and {3, 3}

Input: A[] = {1, 1, 1, 1}, X = 1 
Output: 4 
 */
public class CountSubsetsWithSumK {

	public static void main(String args[]) {
		int A[] = { 3, 3, 3, 3 };
		int sum = 6;
		System.out.println(subsetSum(A, A.length, sum));
		System.out.println(isSumKPossible(A, A.length - 1, sum));

	}

	static int subsetSum(int a[], int n, int sum) {

		// Initializing the matrix
		int dp[][] = new int[n + 1][sum + 1];

		// Initializing the first value of matrix
		dp[0][0] = 1;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {

				// If the value is greater than the sum
				if (a[i - 1] > j)
					dp[i][j] = dp[i - 1][j];

				else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
				}
			}
		}

		return dp[n][sum];
	}

	private static int isSumKPossible(int[] A, int i, int k) {
		if (k == 0)
			return 1;
		if (i == -1)
			return 0;

		int a = isSumKPossible(A, i - 1, k - A[i]);
		int b = isSumKPossible(A, i - 1, k);

		return a + b;
	}
}
