package com.scaler.dsa.dp;

/*
 Given an array of n elements, check if there exist a subset with sum k or not?
 
 A[]={7,4,9,6,10,13,11,14}
 K=22
 
 {7,4,11}  yes
 {7,9,6}   yes
 
Approach:
1- Generate all the subsets and find sum.
	i-Bitmasking 	O(2^n)

A[]={3,1,6}

		0	0	0	{}
		0	0	1	{6}
		0	1	0	{1}
		0	1	1	{1,6}
		1	0	0	{3}
		1	0	1	{3,6}
		1	1	0	{3,1}
		1	1	1	{3,1,6}

So time complexity will be O(2^n * n)

ii- Backtracking   TC-2^n


 */
public class SubsetWithSumK {

	public static void main(String[] args) {
		int A[] = { 4, 2, 1, 3 };
		int k = 7;
		int n = A.length;

		/*
		 * int dp[][] = new int[n + 1][k + 1]; for (int i = 1; i <= n; i++) { for (int j
		 * = 1; j <= k; j++) { dp[i][j] = -1; } }
		 */

		System.out.println(isSumKPossible(A, n - 1, k));
		System.out.println(isSumKPossibleDP(A, n, k));

	}

	// TC-O(n*sum)
	private static boolean isSumKPossibleDP(int[] A, int n, int sum) {
		boolean dp[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				if (i<= n && j < A[i - 1])
					dp[i][j] = dp[i - 1][j];
				if (i<=n && j >= A[i - 1])
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
			}
		}
		return dp[n][sum];
	}

	private static boolean isSumKPossible(int[] A, int i, int k) {
		if (k == 0)
			return true;
		if (i == -1)
			return false;

		boolean a = isSumKPossible(A, i - 1, k - A[i]);
		boolean b = isSumKPossible(A, i - 1, k);

		return a || b;
	}

}
