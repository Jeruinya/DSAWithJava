package com.scaler.dsa.twoPointer;

/*
Problem Description
Given a sorted array of distinct integers A and an integer B, find and return how many 
rectangles with distinct configurations can be created using elements of this array as length 
and breadth whose area is lesser than B.
(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).


Input 1:
 A = [1, 2]
 B = 5
Input 2:
 A = [1, 2]
 B = 1

Output 1: 4
Output 2: 0

Explanation 1:
 All 1X1, 2X2, 1X2 and 2X1 have area less than 5.

Explanation 2:
 No Rectangle is valid.
 */
public class AnotherCountRectangles {

	public static void main(String[] args) {
		int A[] = { 1, 2 };
		int B=5;
		System.out.println(countArea(A,B));
	}

	public static int countArea(int[] A, int B) {

		int n = A.length;
		int i = 0;
		int j = n - 1;
		long ans = 0;
		int mod = 1000000007;

		while (i < n && j >= 0) {
			long area = (long) A[i] * A[j];
			if (area < B) {
				ans = (ans+ j + 1)%mod;
				i++;
			} else
				j--;
		}
		return (int) ans;
	}
}
