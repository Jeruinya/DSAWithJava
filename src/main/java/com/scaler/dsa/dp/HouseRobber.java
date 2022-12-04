package com.scaler.dsa.dp;

import java.util.Arrays;

/*
House robber rob house to get maximum sum without choosing consecutive houses.

A[]=[2	7	9	3	1]

Sum= 2+9+1=12   robbing even indexes.
Sum= 7+3     	robbing odd indexes.

Above one is wrong approach and it will not give the optimal solution.

Counter example:
A[]=[1	1	100	 2	1	100]

Sum= 1+100+1= 102   robbing even indexes.
Sum= 1+2+100= 103  robbing odd indexes.

But the best solution is 1+100+100= 201 , so above one fails.

We have two option for a particular index i.e either choose it or skip it.
if we will choose a particular index then dp[i]= A[i]+dp[i-2]
if we skip a particular index then dp[i]= dp[i-1]

So we have to choose the option which maximize it.
dp[i]= max(A[i]+dp[i-2], dp[i-1])
 */
public class HouseRobber {

	public static void main(String[] args) {
		int A[]= {1,1,100,2,1,100};
		System.out.println(maxAmount(A));
		
		int dp[]= new int[A.length+1];
		Arrays.fill(dp, -1);
		System.out.println(maxAmount(A,A.length,dp));

	}

	//Giving wrong output
	private static int maxAmount(int[] A, int n,int[]dp) {
		if(n==1)
			return A[0];
		if(n==2)
			return Math.max(A[0], A[1]);
		if(dp[n]!=-1)
			return dp[n];
		int inc=A[n-1]*maxAmount(A,n-2,dp);
		int exc=maxAmount(A,n-1,dp);
		dp[n]=Math.max(inc, exc);
		return dp[n];
	}

	private static int maxAmount(int[] A) {
		int n= A.length;
		int dp[]= new int[n];
		dp[0]=A[0];
		dp[1]=Math.max(A[0], A[1]);
		for(int i=2;i<n;i++)
			dp[i]=Math.max(A[i]+dp[i-2], dp[i-1]);
		return dp[n-1];
	}

}
