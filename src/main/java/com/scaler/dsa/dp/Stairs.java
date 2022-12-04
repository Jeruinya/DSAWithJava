package com.scaler.dsa.dp;

/*
Problem Description
You are climbing a staircase and it takes A steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Return the number of distinct ways modulo 1000000007

Problem Constraints
1 <= A <= 105

Input Format
The first and the only argument contains an integer A, the number of steps.

Output Format
Return an integer, representing the number of ways to reach the top.

Input 1: A = 2
Input 2: A = 3

Output 1: 2
Output 2: 3

Explanation 1:
 Distinct ways to reach top: [1, 1], [2].

Explanation 2:
 Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */
public class Stairs {
	static int mod = 1000000007;

	public static void main(String[] args) {
		int A = 3;
		int dp[] = new int[A + 1];

		for (int i = 0; i <= A; i++)
			dp[i] = -1;

		System.out.println(climbStairs(A, dp));
	}

	private static int climbStairs(int n, int[] dp) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (dp[n] != -1)
			return dp[n];

		dp[n] = (climbStairs(n - 1, dp) + climbStairs(n - 2, dp)) % 1000000007;

		return dp[n];
	}

	public static int climbStairs(int A) {
		int dp[] = new int[A + 1]; // dp[i] denotes the number of ways to reach the i'th step.

		if (A == 1)
			return 1;

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= A; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
		}
		return dp[A];
	}
}
