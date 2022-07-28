package com.scaler.dsa.arrays;

import java.util.List;

/*
Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.
(calculate total water )

Problem Constraints
1 <= |A| <= 100000
Input Format
First and only argument is the vector A
Output Format
Return one integer, the answer to the question

Input 1:A = [0, 1, 0, 2]
Input 2:A = [1, 2]

Output 1:1
Output 2:0

Explanation 1:
1 unit is trapped on top of the 3rd element.
Explanation 2:
No water is trapped.

Observation:
	if we can store h units of water above the height of x then there must be a wall of height at least x+h on its left as well as on its right.
 */
public class RainWaterTrappedProblem {

	public static void main(String[] args) {
		int A[] = { 3, 0, 2, 0, 4 };

		int totalWater = maxWater(A);
		System.out.println(totalWater);

		int totalWater1 = maxWaterEfficient(A);
		System.out.println(totalWater1);

		int totalWater2 = maxWaterSuperEfficient(A);
		System.out.println(totalWater2);

	}

	// TC-O(N^2)
	private static int maxWater(int[] A) {
		int res = 0;
		int n = A.length;
		for (int i = 1; i < n - 1; i++) {
			int leftMax = A[i];
			for (int j = 0; j < i; j++)
				leftMax = Math.max(leftMax, A[j]);

			int rightMax = A[i];
			for (int j = i + 1; j < n; j++)
				rightMax = Math.max(rightMax, A[j]);

			res = res + Math.min(leftMax, rightMax) - A[i];
		}
		return res;
	}

	// TC-O(N) SC-O(N)
	public static int maxWaterEfficient(final int[] A) {
		int n = A.length;
		int left[] = new int[n];
		int right[] = new int[n];
		int res = 0;

		left[0] = A[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], A[i]);
		right[n - 1] = A[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], A[i]);

		for (int i = 0; i < n; i++)
			res = res + Math.min(left[i], right[i]) - A[i];

		return res;
	}

	public static int maxWaterSuperEfficient(final int[] A) {

		int n = A.length;
		int left = 0;
		int right = n - 1;
		int res = 0;
		int maxleft = 0, maxright = 0;

		while (left <= right) {

			// When height of left side is lower, calculate height of water trapped in left
			// bin else calculate for right bin
			if (A[left] <= A[right]) {
				if (A[left] >= maxleft)
					maxleft = A[left];
				else
					res += maxleft - A[left];
				left++;
			} else {
				if (A[right] >= maxright)
					maxright = A[right];
				else
					res += maxright - A[right];
				right--;
			}
		}
		return res;
	}

}
