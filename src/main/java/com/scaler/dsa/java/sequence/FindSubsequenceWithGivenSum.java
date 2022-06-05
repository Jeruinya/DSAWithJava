package com.scaler.dsa.java.sequence;

/*
Problem Description
You are given an array of integers of N size.
You have to find that there is any subsequence exists or not whose sum is equal to B.
Problem Constraints
1 <= N <= 20
1 <= A[i] <= 100000
0 <= B <= 1e9
Input Format
First Argument is array of integers A
Second Argument is B
Output Format
Return 1 if any subsequence sum is equal to B otherwise return 0.
Input 1: A=[1,20,13,4,5] B=18
Input 2:   A=[2,2,2,2] B=51
Output 1:1
Output 2:0

Explanation 1:
 There is as subsequence present at indexes 1,3,4 whose sum is 18
Explanation 2: 
There is no possible subsequence whose sum is 5
NOTE: Array is considered 1 based indexing for the above explanation.
 */
public class FindSubsequenceWithGivenSum {

	public static void main(String[] args) {

		int A[] = { 1, 2, 3 };
		int B = 5;
		boolean flag = printSubsequences(A, B);
		System.out.println(flag);

	}

	private static boolean printSubsequences(int[] A, int B) {
		int n = A.length;
		for (int i = 0; i < Math.pow(2, n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0)
					sum = sum + A[j];
			}
			if (sum == B)
				return true;

		}
		return false;

	}

}