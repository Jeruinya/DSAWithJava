package com.scaler.dsa.dp;

/*
LCS-LOngest common subsequence.
Given two strings s1 and s2, find the i- length of LCS  ii- print the LCS

exmaple:

	S1= A B C X Y A B E
	s2= G B X A B Y E
	
		LCS- B X A B E

 	S1= XY
 	S2=YX
 	LCS=X OR Y AND LENGTH IS 1
 
 S1= A B B C D G F
 S2=B A C D E G F
 
 	LCS= B C D G F OR A C D G F

												abcd
												axcd
											
										bcd					abcd
										bxcd		        xcd
							
								cd
						1+		xcd
						
						  	d		cd
							cd      cd
						 			
						 ""        1+lcd(d,d)
						 cd  	   1+ lcs("","")

at one side we can ignore below character and in other side we can ignore other character


 */
public class LCS {

	public static void main(String[] args) {
		String s1 = "ABCXYAABE";
		String s2 = "GBXABYE";
		System.out.println(lcs(s1, s2, 0, 0));

		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				dp[i][j] = -1;
		System.out.println(lcsTopDownDP(s1, s2, 0, 0, dp));

		System.out.println(lcsBottomUpDP(s1, s2));
	}

	private static int lcsBottomUpDP(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n+1][m+1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;

		for (int j = 0; j <= m; j++)
			dp[0][j] = 0;
		
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++)
				if(s1.charAt(i)==s2.charAt(j))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);

		return dp[n-1][m-1];
	}

	// Time- O(M*N) Space-(M*N)
	private static int lcsTopDownDP(String s1, String s2, int i, int j, int[][] dp) {
		if (i == s1.length() || j == s2.length())
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i) == s2.charAt(j))
			return 1 + lcsTopDownDP(s1, s2, i + 1, j + 1, dp);

		dp[i][j] = Math.max(lcsTopDownDP(s1, s2, i + 1, j, dp), lcsTopDownDP(s1, s2, i, j + 1, dp));
		return dp[i][j];
	}

	// Time- 2^M+N
	private static int lcs(String s1, String s2, int i, int j) {
		if (i == s1.length() || j == s2.length())
			return 0;
		if (s1.charAt(i) == s2.charAt(j))
			return 1 + lcs(s1, s2, i + 1, j + 1);

		return Math.max(lcs(s1, s2, i + 1, j), lcs(s1, s2, i, j + 1));
	}

}
