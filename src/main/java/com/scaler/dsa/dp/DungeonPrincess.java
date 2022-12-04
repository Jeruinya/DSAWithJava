package com.scaler.dsa.dp;

import java.util.Arrays;

/*
Problem Description
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. 
The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in 
the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. 
If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so 
that he is able to rescue the princess.



Problem Constraints
1 <= M, N <= 500
-100 <= A[i] <= 100

Input Format
First and only argument is a 2D integer array A denoting the grid of size M x N.

Output Format
Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.

Input 1:
 A = [ 
       [-2, -3, 3],
       [-5, -10, 1],
       [10, 30, -5]
     ]
Input 2:
 A = [ 
       [1, -1, 0],
       [-1, 1, -1],
       [1, 0, -1]
     ]


Output 1: 7
Output 2: 1

Explanation 1:
 Initially knight is at A[0][0].
 If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required will be 7.
 At (0,0) he looses 2 health, so health becomes 5.
 At (0,1) he looses 3 health, so health becomes 2.
 At (0,2) he gains 3 health, so health becomes 5.
 At (1,2) he gains 1 health, so health becomes 6.
 At (2,2) he looses 5 health, so health becomes 1.
 At any point, the health point doesn't drop to 0 or below. So he can rescue the princess with minimum health 7.
 

Explanation 2:
 Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.
 
Approach: C

Case-1: H[]={-5}  x-5=1  so minimum health required is 6

Case-2: H[]= -2
			 -5    x-2=6 => x=8

Case-3: H[]={-4, -5}   x-4= 6  => x=10

Case-4: H[][]={{-3,-2},
			   {-4,-5}}   
			   
	    dp[][]={{11,8}
	            {10,6}}     x-3=min(10,8)  => x-3=8=> x=11

Case-5: H[][]={{9,-2}
			   {-4,-5}}
			   
	  dp[][]={{1, 8}
	  		  {10,6}}
	  		  
	  x+9=min(10,8)=>  x+9=8 => x=-1
	  
So at beginning health can not be negative because if its -ve , we can not survive the queen.

		X+h[i][j]=min(dp[i+1][j],dp[i][j+1])
		x= min(dp[i+1][j],dp[i][j+1])-H[i][j]

dp[i][j]>=1

dp[i][j]=max(1,(min(dp[i+1][j],dp[i][j+1])-H[i][j]))

H[][]={{3,6,-3},
	   {-5,9,-2},
	   {2,-4,-4}}

int dp[][]={{1,1,11},
			{6,1,8},
			{8,10,6}}

 */
public class DungeonPrincess {

	public static void main(String[] args) {
		int A[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP(A));

		int m = A.length;
		int n = A[0].length;
		int dp[][] = new int[m + 1][n + 1];
		for (int[] x : dp)
			Arrays.fill(x, -1);

		System.out.println(minHealth(A, dp, 0, 0, m, n));

	}

	private static int minHealth(int A[][], int dp[][], int i, int j, int m, int n) {
		if (i == m || j == n)
			return Integer.MAX_VALUE;
		if (i == m - 1 && j == n - 1)
			return Math.max(1, 1 - A[i][j]);
		if (dp[i][j] != -1)
			return dp[i][j];

		int a = minHealth(A, dp, i + 1, j, m, n);
		int b = minHealth(A, dp, i, j + 1, m, n);
		dp[i][j] = Math.max(1, Math.min(a, b) - A[i][j]);

		return dp[i][j];
	}

	public static int calculateMinimumHP(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		int dp[][] = new int[m + 1][n + 1];
		for (int[] x : dp) {
			Arrays.fill(x, Integer.MAX_VALUE);
		}
		dp[m - 1][n - 1] = Math.max(1, 1 - A[m - 1][n - 1]);

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1)
					continue;
				dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j]);
			}

		}
		return dp[0][0];
	}
}
