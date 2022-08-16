package com.scaler.dsa.bitManipulation;

import java.util.Arrays;

/*
Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. 
Report the minimum XOR value.

Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109

Input Format
First and only argument of input contains an integer array A.

Output Format
Return a single integer denoting minimum xor value.

Input 1: A = [0, 2, 5, 7]
Input 2: A = [0, 4, 7, 9]

Output 1: 2
Output 2: 3

Explanation 1:

 0 xor 2 = 2
 
Here we are shorting the array because when we will take the XOR of two closest pair then the XOR will be minimum.
example:
a=1010 
a+1=1011
a^a+1=
1 0 1 0
1 0 1 1
---------
0 0 0 1

A[]={20,6,4,10}
All pairs=(20,6)	(20,4)	(20,10)	(6,4)	(6,10)	(4,10)

20	10100
6	00110
4	00100
10	01010

{4,6,10,20}
all pairs in efficient way after shorting: (4,6)	(6,10)	 (10,20)  number of pairs are less now so we have 
to do less comparison. 


 */
public class MinXORvalue {

	public static void main(String[] args) {
		int A[] = { 0, 2, 5, 7 };
		System.out.println(findMinXORNaive(A));
		System.out.println(findMinXOREff(A));
	}

	// TC-O(n^2) SC-O(1)
	private static int findMinXORNaive(int[] A) {

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int xor = A[i] ^ A[j];
				res = Math.min(res, xor);
			}
		}
		return res;
	}

	private static int findMinXOREff(int[] A) {
		Arrays.sort(A);
		int res = A[0] ^ A[1];
		for (int i = 1; i < A.length - 1; i++)
			res = Math.min(res, A[i] ^ A[i + 1]);
		return res;
	}
}
