package com.scaler.dsa.dp;

/*
Problem Description
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.

Problem Constraints
1 <= A <= 105

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the minimum count.

Input 1: A = 6
Input 2: A = 5

Output 1: 3
Output 2: 2

Explanation 1:
 Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 Minimum count of numbers, sum of whose squares is 6 is 3. 

Explanation 2:
 We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 
N=6
2^2+1^2+1^2=6   so count of number is 3

N=9
2^2+2^+1^1= 9
3^2= 9 
So count of the number is 1

X1^2+ X2^2+X3^2...............=N
N-X1^2- X2^2-X3^2..................=0

Above one is greedy approach, so we will try to find a case when greedy will fails and if it not fails then its the solution.

N=12
3^2+1^2+1^2+1^2   count of number is 4

2^2+2^2+2^2   =12 and count of number is 3 which is less than the greedy approach so its greedy failed here.

-When greedy approach fails then we have two choice either use another greedy approach or use DP.

Question: What is the difference between greedy and DP?
Greedy: Greedy will try to maximize the profit at current point of time.
DP: DP will try to explore all the possibilities and see what can be the best possible solution.
 */
public class MinimumNumberOfSquares {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(countMinSquares(n));

	}

	public static int countMinSquares(int n) {
		int[] dp = new int[n + 1];

		// simple base case assignment
		dp[0] = 0;
		dp[1] = 1;

		// finding optimal answer for every 2<=i<=N in bottom-up manner
		for (int i = 2; i <= n; i++) {

			// for i answer will be always less than equal to i.
			// maximum possible number of squares : i = (1^1+1^1+1^1+.....+1^1, i times)
			dp[i] = i;

			// Now identify from which number we have to make a direct jump to N so that the
			// required answer is minimised.
			// do this by considering every possible direct jump
			// number of iterations will be <= sqrt(i)
			for (int x = 1; x * x <= i; x++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
			}
		}

		// here we get our optimal answer
		return dp[n];
	}

}
