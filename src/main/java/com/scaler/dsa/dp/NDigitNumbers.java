package com.scaler.dsa.dp;

/*
Problem Description
Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.

Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

Problem Constraints
1 <= A <= 1000
1 <= B <= 10000

Input Format
First argument is the integer A
Second argument is the integer B

Output Format
Return a single integer, the answer to the problem

Input 1:
 A = 2
 B = 4
Input 2:
 A = 1
 B = 3

Output 1: 4
Output 2: 1

Explanation 1:
 Valid numbers are {22, 31, 13, 40}
 Hence output 4.

Explanation 2:
 Only valid number is 3
 */
public class NDigitNumbers {
	static int dp[][] = new int[1001][10001];

	public static void main(String[] args) {
		int A = 2;
		int B = 4;
		int ans = 0;
		for (int i = 0; i < A + 1; i++) {
			for (int j = 0; j < B + 1; j++)
				dp[i][j] = -1;
		}
		for (int i = 1; i < 10; i++) {
			ans += rec(A - 1, B - i);
			ans %= 1000000007;
		}
		System.out.println(ans);

	}

	static int rec(int id, int sum) {
		if (sum < 0)
			return 0;
		if (id == 0 && sum == 0)
			return 1;
		if (id == 0)
			return 0;
		if (dp[id][sum] != -1)
			return dp[id][sum];
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += rec(id - 1, sum - i);
			ans %= 1000000007;
		}
		return dp[id][sum] = ans;
	}

}
