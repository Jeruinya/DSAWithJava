package com.scaler.dsa.dp;

/*
Given a 6 faced dice, count the number of ways to get a sum n, if you can roll dice as many times as required.

Example:
Sum=4

dice
. 		1+3  (1,1,1), (1,2), (2,1), (3)
..		2+2  (1,1),(2)

...		3+1  (1)

....	4+0  (1)
----------------------------
Total ways = 8


 */
public class DiceProblem {

	public static void main(String[] args) {
		int sum = 4;
		System.out.println(findDiceSum(sum));

		int dp[] = new int[sum + 1];

		System.out.println(findDiceSumTopDownDP(sum, dp));
		System.out.println(findDiceSumBottomUpDP(sum));

	}

	// TC-O(n) Space-O(n)
	private static int findDiceSumBottomUpDP(int n) {
		int dp[] = new int[n + 1];

		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			int ans = 0;

			for (int j = 1; j <= 6; j++) {
				if ((i - j) >= 0) {
					ans = ans + dp[i - j];
				}
			}
			dp[i] = ans;
		}
		return dp[n];
	}

	// TC-O(6^n) Space-O(n)
	private static int findDiceSum(int n) {
		// base case
		if (n == 0)
			return 1;

		// rec case
		int ans = 0;
		for (int i = 1; i <= 6; i++) {
			if (n - i >= 0) {
				ans = ans + findDiceSum(n - i);
			}
		}
		return ans;
	}

	// TC-O(n) Space-O(n)
	private static int findDiceSumTopDownDP(int n, int[] dp) {
		// base case
		if (n == 0)
			return 1;

		// check before computing
		if (dp[n] != 0)
			return dp[n];

		// rec case
		int ans = 0;
		for (int j = 1; j <= 6; j++) {
			if (n - j >= 0) {
				ans = ans + findDiceSumTopDownDP(n - j, dp);
			}
		}
		// save before return
		return dp[n] = ans;
	}

}
