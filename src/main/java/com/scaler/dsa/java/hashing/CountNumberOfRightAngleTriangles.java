package com.scaler.dsa.java.hashing;

import java.util.HashMap;

/*
Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N 
represents a unique point (x, y) in 2D Cartesian plane.
Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) 
form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).

Problem Constraints
1 <= N <= 105
0 <= A[i], B[i] <= 109

Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.
Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).

Input 1:
 A = [1, 1, 2]
 B = [1, 2, 1]
 
Input 2:
 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]

Output 1: 1
Output 2: 6

Explanation 1:
 All three points make a right angled triangle. So return 1.

Explanation 2:
 6 triplets which make a right angled triangle are:    (1, 1), (1, 2), (2, 2)
                                                       (1, 1), (3, 1), (1, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)
 
Suppose we have three points plain then these points can only form Right angled triangle only if p1.y=p2.y and p1.x=p3.x
			.
			.	.p3(x3,y3)
			.
			.	.p1(x1,y1)		.p2(x2,y2)
.....................................................
			.
			.
			.

Example: (1,5)	(1,3)	(3,3)	(6,3)	(1,-8)	(1,-10)  there will be 6 right angled triangle will be formed.

if any issue refer Advance hashing 3 notes 

 */
public class CountNumberOfRightAngleTriangles {

	public static void main(String[] args) {
		int A[] = { 1, 1, 2, 3, 3 };
		int B[] = { 1, 2, 1, 2, 1 };

		System.out.println(countNumberOfRightAngleTriangles(A, B));

	}

	private static int countNumberOfRightAngleTriangles(int[] A, int[] B) {
		int count = 0;
		int mod = 1000000007;
		HashMap<Integer, Integer> hmx = new HashMap<>();
		HashMap<Integer, Integer> hmy = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			hmx.put(A[i], hmx.getOrDefault(A[i], 0) + 1);
			hmy.put(B[i], hmy.getOrDefault(B[i], 0) + 1);
		}

		for (int i = 0; i < A.length; i++) {
			int x = hmx.get(A[i]) - 1;
			int y = hmy.get(B[i]) - 1;

			count = (count + ((x % mod * y % mod)) % mod) % mod;

		}

		return count;
	}

}
