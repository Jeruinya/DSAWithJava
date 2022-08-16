package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Problem Description
Given an array A of size N, Groot wants you to pick 2 indices i and j such that
1 <= i, j <= N
A[i] % A[j] is maximum among all possible pairs of (i, j).
Help Groot in finding the maximum value of A[i] % A[j] for some i, j.

Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 100000

Input Format
First and only argument in an integer array A.

Output Format
Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.

Input 1: A = [1, 2, 44, 3]
Input 2: A = [2, 6, 4]

Output 1: 3
Output 2: 4

Explanation 1:
 For i = 3, j = 2  A[i] % A[j] = 3 % 44 = 3.
 No pair exists which has more value than 3.
Explanation 2:

 For i = 2, j = 1  A[i] % A[j] = 4 % 6 = 4.
 
 Obs:  A%B will be maximum when A<B and A & B are maximum.A is the second largest in array and B is the largest in the array.
 */
public class MaxMod {

	public static void main(String[] args) {
		int A[] = { 1, 2, 44, 3 };
		System.out.println(maxModNaive(A));
		System.out.println(maxModEff(A));
		System.out.println(maxModMoreEff(A));

	}

	private static int maxModMoreEff(int[] A) {
		int first=Integer.MIN_VALUE;
		int second=Integer.MIN_VALUE;
		int n= A.length;
		
		for(int i=0;i<n;i++) {
			if(first<A[i]) {
				second=first;
				first=A[i];
			}
			
			else if(second<A[i] && A[i]!=first)
				second=A[i];
		}
		return second==Integer.MIN_VALUE?0:second;
	}

	//TC-O(nlogn)
	private static int maxModEff(int[] A) {
		Arrays.sort(A);
		int n=A.length;

		return A[n-2];
	}

	//TC-O(n^2)
	private static int maxModNaive(int[] A) {
		int n = A.length;
		int max_mod = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (max_mod < A[i] % A[j])
					max_mod = A[i] % A[j];
		return max_mod;
	}

}
