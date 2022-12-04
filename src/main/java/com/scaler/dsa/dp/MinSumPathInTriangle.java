package com.scaler.dsa.dp;

import java.util.ArrayList;

/*
Problem Description
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is

Problem Constraints
|A| <= 1000
A[i] <= 1000

Input Format
First and only argument is the vector of vector A defining the given triangle

Output Format
Return the minimum sum

Input 1: 
A = [ 
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:
 A = [ [1] ]

Output 1: 11
Output 2: 1

Explanation 1:
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Explanation 2:
 Only 2 can be collected.
 */
public class MinSumPathInTriangle {

	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);

		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);
		l2.add(4);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(5);
		l3.add(6);
		l3.add(7);
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);

		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(l1);
		A.add(l2);
		A.add(l3);
		A.add(l4);
		System.out.println(minimumTotal(A));
		System.out.println(minimumTotal1(A));

	}

	public static int minimumTotal(ArrayList<ArrayList<Integer>> A) {
		int m = A.size();
		int n = A.get(m - 1).size();
		int[] dp = new int[n + 1];
		int size = n;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < size; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + A.get(i).get(j);
			}
			size--;
		}
		return dp[0];
	}

	public static int minimumTotal1(ArrayList<ArrayList<Integer>> A) {
		int n = A.size();
		int m = A.get(n - 1).size();
		int[][] dp = new int[n+1][m+1];

		// fill the last row of dp table with the last row of input triangle
		for (int i = 0; i < m; i++)
			dp[n - 1][i] = A.get(n - 1).get(i);

		// dp state dp[i] = sum of input triangle cell [i][j] + Min(dp[i + 1][j]) and
		// dp[i + 1][j + 1])
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				dp[i][j] = A.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
			}
		}

		return dp[0][0];
	}

}
