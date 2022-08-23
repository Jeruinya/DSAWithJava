package com.scaler.dsa.binarySearch;

import java.util.Arrays;

/*
Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element 
of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. 
To prevent the cows from hurting each other, John wants to assign the cows to the stalls, 
such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.

Input 1:
A = [1, 2, 3, 4, 5]
B = 3
Input 2:
A = [1, 2]
B = 2

Output 1: 2
Output 2: 1

Explanation 1:
 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 
Explanation 2:
 The minimum distance will be 1.
 */
public class AggressiveCows {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int B = 3;
		System.out.println(MaxDistance(A, B));

	}

	public static int MaxDistance(int[] A, int B) {
		Arrays.sort(A);
		int ans = 0;
		int s = 1;
		int e = 1000000000;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (isPossible(A, B, mid)) {
				ans = mid;
				s = mid + 1;
			} else
				e = mid - 1;
		}
		return (int) ans;
	}

	public static boolean isPossible(int A[], int B, int mid) {
		int count = 1;
		int cows = A[0];

		for (int i = 1; i < A.length; i++) {
			if (A[i] - cows >= mid) {
				cows = A[i];
				count++;
				if (count >= B)
					return true;
			}
		}
		return false;
	}

}