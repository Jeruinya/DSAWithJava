package com.scaler.dsa.dp;

/*
Given a ladder of N steps, a kid wants to reach nth step from starting, boy can take jump of 1, 2 , 3.....k steps at a time. 
Find number of ways the kid can climb the ladder.
Example: 
N=4
k=3

(1 1 1 1), (1 2 1) (1 1 2),(2 1 1), (2 2), (1 3), (3,1)

						       f(4)
					
				f(3)		        f(2)		   f(1)
		
		f(2)	 	f(1)	f(0)    f(1)	f(0)    f(0)
	
   f(1)		f(0)   f(0)
   
f(0)

Ans:7

f(n)= f(n-1)+f(n-2)+f(n-3)

 */
public class LadderProblem1 {

	public static void main(String[] args) {
		int n = 4;
		int k = 4;
		System.out.println(findWaysBottomUpDP(n, k));
		System.out.println(findWaysBottomUpDPEff(n, k));

	}

	// TC-O(n) Space-O(1)
		private static int findWaysBottomUpDPEff(int n, int k) {
			int dp[] = new int[n + 1];

			dp[0] = dp[1] = 1;
			for (int i = 2; i <= n; i++) {
				if (i <= k)
					dp[i] = 2 * dp[i - 1];
				else
					dp[i] = 2 * dp[i - 1] - dp[i - k - 1];

			}
			return dp[n];

		}

	private static int findWaysBottomUpDP(int n, int k) {
		int dp[] = new int[n + 1];

		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			int ans = 0;

			for (int j = 1; j <= k; j++) {
				if ((i - j) >= 0) {
					ans = ans + dp[i - j];
				}
			}
			dp[i] = ans;
		}
		return dp[n];
	}

}
