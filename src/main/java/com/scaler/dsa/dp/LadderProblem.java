package com.scaler.dsa.dp;
/*
Given a ladder of N steps, a kid wants to reach nth step from starting, boy can take jump of 1, 2 or 3 steps at a time. Find number
of ways the kid can climb the ladder.
Example: 
N=4

(1 1 1 1), (1 2 1) (1 1 2),(2 1 1), (2 2), (1 3), (3,1)

						       f(4)
					
				f(3)		        f(2)		   f(1)
		
		f(2)	 	f(1)	f(0)    f(1)	f(0)    f(0)
	
   f(1)		f(0)   f(0)
   
f(0)

Ans:7

f(n)= f(n-1)+f(n-2)+f(n-3)

 */
public class LadderProblem {

	public static void main(String[] args) {
		int n=4;
		int dp[]= new int[n+1];
		
		for(int i=0;i<=n;i++)
			dp[i]=-1;
		
		System.out.println(findWays(n));
		System.out.println(findWaysTowDownDP(n,dp));
		System.out.println(findWaysBottomUpDP(n));


	}

	private static int findWaysBottomUpDP(int n) {
		int dp[]= new int[n+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=n;i++)
			dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		
		return dp[n];
	}

	private static int findWays(int n) {
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		return findWays(n-1)+findWays(n-2)+findWays(n-3);
	}
	
	private static int findWaysTowDownDP(int n, int[] dp) {
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		if(dp[n]!=-1)
			return dp[n];
		
		dp[n]=findWaysTowDownDP(n-1,dp)+findWaysTowDownDP(n-2,dp)+findWaysTowDownDP(n-3,dp);
		
		return dp[n];
	}

	

}
