package com.scaler.dsa.bitManipulation;

/**
Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Input 1: A = [1, 2, 2, 3, 1]
Input 2: A = [1, 2, 2]
Output 1: 3
Output 2: 1

 */

public class ReturnSingleUniqueNumber {

	public static void main(String[] args) {
		int A[] = { 1, 2, 2, 3, 1 };
		int ans = 0;
		for (int i = 0; i < A.length; i++)
			ans = ans ^ A[i];

		System.out.println(ans);
	}
}