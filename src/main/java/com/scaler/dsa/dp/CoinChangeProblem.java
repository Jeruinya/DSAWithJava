package com.scaler.dsa.dp;

import java.util.Arrays;
/*

 */
public class CoinChangeProblem {

	public static void main(String[] args) {
		int n = 15;
		int coins[] = { 1, 7, 10 };
		System.out.println(minCoins(n, coins));

		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(minCoins(n,coins,dp));

	}

	// Top Down for coin change -----
	// rec soln + Memoisation
	static int minCoins(int n, int coins[], int dp[]) {
		// base case
		if (n == 0) {
			return 0;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		// rec case
		int currentAns = Integer.MAX_VALUE;
		for (int coin : coins) {
			if (n - coin >= 0) {
				int subProb = minCoins(n - coin, coins, dp);
				currentAns = Math.min(currentAns, subProb + 1);
			}
		}
		return dp[n] = currentAns;
	}

	static int minCoins(int n, int coins[]) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int currentAns = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i - coin >= 0) {
					currentAns = Math.min(currentAns, dp[i - coin] + 1);
				}
			}
			dp[i] = currentAns;
		}
		return dp[n];
	}

}
