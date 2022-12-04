package com.scaler.dsa.dp;

import java.util.Arrays;

/*
Problem Description

In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.


Problem Constraints
1 <= A <= 105

Input Format
Given only argument A of type Integer, number of people in Danceland.

Output Format
Return an integer denoting the number of ways people of Danceland can party.


Input 1: A = 3
Input 2: A = 5

Output 1: 4
Output 2: 26


Explanation 1:
 Let suppose three people are A, B, and C. There are only 4 ways to party
 (A, B, C) All party alone
 (AB, C) A and B party together and C party alone
 (AC, B) A and C party together and B party alone
 (BC, A) B and C party together and A
 here 4 % 10003 = 4, so answer is 4. 

Explanation 2:
 Number of ways they can party are: 26.
 
Approach:
Every person can either pair with another person or can remain single.
Let us consider the kth person, he can either remain single or he can pair up with someone from [1, k-1].

So here recurrence relation is :
Number_of_ways(k-1) + (k-1) * Number_of_ways(k-2)

and by using dynamic programming we can solve overlapping subproblems.
i.e. dp[i] = dp[i-1] + dp[i-2] * (i-1)
 */
public class LetParty {

	public static void main(String[] args) {
		int A = 4;
		int dp[] = new int[A + 1];
		Arrays.fill(dp, -1);

		System.out.println(totalWaysTopDownDP(A, dp));
		System.out.println(totalWaysBottomUpDP(A));

	}

	private static int totalWaysBottomUpDP(int A) {
		if(A==1|| A==2)
            return A;

       int dp[] = new int[A + 1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=A;i++)
			dp[i]=(dp[i-1]+(i-1)*dp[i-2])%10003;
		return dp[A];
	}

	private static int totalWaysTopDownDP(int n, int dp[]) {

		if (n == 1 || n == 2)
			return n;

		if (dp[n] != -1)
			return dp[n];

		int mod = 10003;
		dp[n] = (totalWaysTopDownDP(n - 1, dp) + (n - 1) * totalWaysTopDownDP(n - 2, dp)) % mod;

		return dp[n];
	}
}
