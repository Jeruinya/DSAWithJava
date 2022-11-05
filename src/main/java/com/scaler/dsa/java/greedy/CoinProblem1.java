package com.scaler.dsa.java.greedy;

public class CoinProblem1 {

	public static void main(String[] args) {
		int A = 47;
		int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

		System.out.println(findMinCoins(coins, A));

	}

	public static int findMinCoins(int[] coins, int A) {

		int ans = 0;
		int n = coins.length - 1;
		for (int i = n; i >= 0; i--) {
			ans += A / coins[i];
			A = A % coins[i];
		}
		return ans;
	}

}
