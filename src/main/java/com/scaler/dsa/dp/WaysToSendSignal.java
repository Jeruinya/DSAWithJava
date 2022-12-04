package com.scaler.dsa.dp;
/*
Problem Description

You are trying to send signals to aliens using a linear array of A laser lights. 
You don't know much about how the aliens are going to percieve the signals, 
but what you know is that if two consecutive lights are on then the aliens might take it as a 
sign of danger and destroy the earth.

Find and return the total number of ways in which you can send a signal without compromising the safty of
 the earth. Return the ans % 109 + 7.


Problem Constraints
1 <= A <= 105
Input Format
The only argument given is integer A.

Output Format
Return the ans%(109+7).

Input 1: A = 2
Input 2: A = 3

Output 1: 3
Output 2: 5

Explanation 1:
 OFF OFF
 OFF ON 
 ON OFF
All lights off is also a valid signal which probably means 'bye'

Explanation 2:
 OFF OFF OFF
 OFF OFF ON
 OFF ON OFF 
 ON OFF OFF
 ON OFF ON
 
 Dp recurrence:-
DP[0][i] = DP[0][i-1] + DP[1][i-1]
DP[1][i] = DP[0][i-1]
DP[0][i] = Count of all possible binary strings of lenght i without having consecutive 1's and ending at 0
DP[1][i] = Count of all possible binary strings of length i without having consecutive 1's and ending at 1


 */
public class WaysToSendSignal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int solve(int A) {
	        int dp[][]=new int[A+1][2];
	        int mod=1000000007;

	        dp[0][0]=0;
	        dp[0][1]=0;
	        dp[1][0]=1;
	        dp[1][1]=1;

	        for(int i=2;i<=A;i++){
	            dp[i][0]= (dp[i-1][0]+dp[i-1][1])%mod;
	             dp[i][1]= dp[i-1][0]%mod;
	        }
	        return (dp[A][0]+dp[A][1])%mod;
	    }
}
