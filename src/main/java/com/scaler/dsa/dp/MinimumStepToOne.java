package com.scaler.dsa.dp;

/*
Given any number n, find minimum number of ways to convert that number to one.
The allowed operations are :
		i- divide n by 3 if n is divisible by 3. 
		ii- divide n by 2 if n is divisible by 2. 
		iii- n-1 

Example:
9--->3--->1   so total minimum 2 steps are required.
 */
public class MinimumStepToOne {

	public static void main(String[] args) {
		int n = 9;
		System.out.println(countWaysToOne(n));
		int dp[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			dp[i] = -1;

		System.out.println(countWaysToOneTopDownDP(n, dp));
		//System.out.println(countWaysToOneBottomUpDP(n));
	}

	/*
	 * private static int countWaysToOneBottomUpDP(int n) { int dp[]= new int[n+1];
	 * dp[1]=0; for(int i=2;i<=n;i++) { int x=Integer.MAX_VALUE; int y=
	 * Integer.MAX_VALUE; if(i%2==0) dp[i]=dp[i/2]; if(i) }
	 * 
	 * return null; }
	 */

	private static int countWaysToOneTopDownDP(int n, int[] dp) {
		if (n == 1)
			return 0;

		if (dp[n] != -1)
			return dp[n];

		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		if (n % 3 == 0)
			x = countWaysToOne(n / 3);
		if (n % 2 == 0)
			y = countWaysToOne(n / 2);

		int z = countWaysToOne(n - 1);

		int res = Math.min(x, y);
		dp[n] = Math.min(z, res) + 1;

		return dp[n];
	}

	private static int countWaysToOne(int n) {
		if (n == 1)
			return 0;
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		if (n % 3 == 0)
			x = countWaysToOne(n / 3);
		if (n % 2 == 0)
			y = countWaysToOne(n / 2);

		int z = countWaysToOne(n - 1);

		int res = Math.min(x, y);

		return Math.min(z, res) + 1;
	}
}
