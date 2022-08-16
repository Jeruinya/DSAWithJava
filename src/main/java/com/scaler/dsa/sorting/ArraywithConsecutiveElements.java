package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Problem Description
Given an array of positive integers A, check and return whether the array elements are consecutive or not.
NOTE: Try this with O(1) extra space.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
Input Format
The only argument given is the integer array A.

Output Format
Return 1 if the array elements are consecutive else return 0.

Input 1: A = [3, 2, 1, 4, 5]
Input 2: A = [1, 3, 2, 5]

Output 1: 1
Output 2: 0

Explanation 1:
 As you can see all the elements are consecutive, so we return 1.
Explanation 2:

 Element 4 is missing, so we return 0.
 */
public class ArraywithConsecutiveElements {

	public static void main(String[] args) {
		int[] A = { 3, 2, 1, 4, 5 };
		System.out.println(isArrayElementsConsecutive(A));
	}

	public static int isArrayElementsConsecutive(int[] A) {
		Arrays.sort(A);

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i + 1] - A[i] != 1)
				return 0;
		}

		return 1;
	}
}
