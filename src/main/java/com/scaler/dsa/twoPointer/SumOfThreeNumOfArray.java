package com.scaler.dsa.twoPointer;

import java.util.Arrays;

/*
Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. 
Return the sum of those three integers.
Assume that there will only be one solution.

Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108
Input Format
First argument is an integer array A of size N.
Second argument is an integer B denoting the sum you need to get close to.

Output Format
Return a single integer denoting the sum of three integers which is closest to B.

Input 1:
A = [-1, 2, 1, -4]
B = 1
Input 2: 
A = [1, 2, 3]
B = 6

Output 1:2
Output 2:6

Explanation 1:
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

Explanation 2:
 Take all elements to get exactly 6.
 */
public class SumOfThreeNumOfArray {

	public static void main(String[] args) {
		int A[] = { -1, 2, 1, -4 };
		int B = 1;
		System.out.println(threeSumClosest(A, B));
		System.out.println(threeSumClosestEff(A, B));

	}

	public static int threeSumClosestEff(int[] A, int B) {
		int n = A.length, diff = 1000000000, ans = -1;
		Arrays.sort(A);
		for (int i = 0; i < n; i++) {
			int j = i + 1, k = n - 1;
			while (j < k) {
				if (Math.abs(A[i] + A[j] + A[k] - B) < diff) {
					diff = Math.abs(A[i] + A[j] + A[k] - B);
					ans = A[i] + A[j] + A[k];
				}
				if (A[i] + A[j] + A[k] > B)
					k--;
				else
					j++;
			}
		}
		return ans;
	}

	// Not working
	public static int threeSumClosest(int[] A, int B) {
		int n = A.length;
		int current = Integer.MIN_VALUE;

		if (B == 0)
			return 0;
		for (int i = 0; i < n - 2; i++)
			for (int j = i + 1; j < n - 1; j++)
				for (int k = j + 1; k < n; k++)
					if (Math.abs(A[i] + A[j] + A[k] - B) < Math.abs(current - B))
						current = A[i] + A[j] + A[k];

		return current;
	}
}
