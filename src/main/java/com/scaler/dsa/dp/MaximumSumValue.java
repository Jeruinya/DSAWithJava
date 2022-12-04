package com.scaler.dsa.dp;

/*
Problem Description

You are given an array A of N integers and three integers B, C, and D.
You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.


Problem Constraints
1 <= N <= 105
-10000 <= A[i], B, C, D <= 10000

Input Format
First argument is an array A
Second argument is an integer B
Third argument is an integer C
Fourth argument is an integer D

Output Format
Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.

Input 1:
 A = [1, 5, -3, 4, -2]
 B = 2
 C = 1
 D = -1
Input 2:
 A = [3, 2, 1]
 B = 1
 C = -10
 D = 3


Output 1: 18
Output 2: -4


Explanation 1:
 If you choose i = 2, j = 2, and k = 3 then we will get
 A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18

Explanation 2:
 If you choose i = 1, j = 3, and k = 3 then we will get
 A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
 */
public class MaximumSumValue {

	public static void main(String[] args) {
		int A[] = { 1, 5, -3, 4, -2 };
		int B = 2;
		int C = 1;
		int D = -1;

		System.out.println(findMaxSumNaive(A, B, C, D));
		System.out.println(findMaxSumeEff(A, B, C, D));
		System.out.println(findMaxSumeEffDP(A, B, C, D));

	}

	private static int findMaxSumeEff(int[] A, int B, int C, int D) {
		int n = A.length;
		int left[] = new int[n];
		int right[] = new int[n];

		left[0] = A[0] * B;
		right[n - 1] = A[n - 1] * D;

		for (int i = 1; i < n; i++)
			left[i] = Math.max(A[i] * B, left[i - 1]);

		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(A[i] * D, right[i + 1]);

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			ans = Math.max(ans, left[i] + right[i] + (A[i] * C));
		return ans;
	}

	public static int findMaxSumeEffDP(int[] A, int B, int C, int D) {
		int n = A.length;
		int[][] dp = new int[n + 1][3]; // dp array to store answer of previous states

		for (int i = 0; i <= n; i += 1) {
			dp[i][0] = dp[i][1] = dp[i][2] = -1000000000; // Initialize the dp array with minus infinity
		}

		for (int i = 1; i <= n; i += 1) {
			dp[i][0] = Math.max(dp[i - 1][0], A[i - 1] * B); // Maximum value of A[i]*B
			dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + A[i - 1] * C); // Maximum value of A[i]*B + A[j]*C
			dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + A[i - 1] * D); // Maximum value of A[i]*B + A[j]*C + A[k]*D
		}

		return dp[n][2]; // return the answer.
	}

	private static int findMaxSumNaive(int[] A, int B, int C, int D) {
		int n = A.length;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				for (int k = j; k < n; k++) {
					int sum = A[i] * B + A[j] * C + A[k] * D;
					ans = Math.max(ans, sum);
				}
			}
		}
		return ans;
	}

}
