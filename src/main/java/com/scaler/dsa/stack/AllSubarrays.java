package com.scaler.dsa.stack;

import java.util.Stack;

/*
Problem Description
Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.
Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
Find and return the maximum value of XOR among all subarrays.


Problem Constraints
2 <= N <= 105
1 <= A[i] <= 107

Input Format
The only argument is an integer array A.

Output Format
Return an integer, i.e., the maximum value of XOR of maximum and 2nd maximum element among all subarrays.

Input 1: A = [2, 3, 1, 4]
Input 2: A = [1, 3]

Output 1: 7
Outnput 2: 2

Explanation 1:
 All subarrays of A having size greater than 1 are:
 Subarray            XOR of maximum and 2nd maximum no.
 1. [2, 3]           1
 2. [2, 3, 1]        1
 3. [2, 3, 1, 4]     7
 4. [3, 1]           2
 5. [3, 1, 4]        7
 6. [1, 4]           5
 So maximum value of Xor among all subarrays is 7.

Explanation 2:
 Only subarray is [1, 3] and XOR of maximum and 2nd maximum is 2.
 */
public class AllSubarrays {

	public static void main(String[] args) {
		int A[] = { 2, 3, 1, 4 };
	
		System.out.println(maxXorOfMaxAndSecondMaxOfSubarray(A));
		System.out.println(maxXorOfMaxAndSecondMaxOfSubarrayEff(A));

	}
	//Time-O(n)  Space-O(n) 
	public static int maxXorOfMaxAndSecondMaxOfSubarrayEff(int[] A) {
		int ans = 0;
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < A.length; i++) {
			while (!s.isEmpty()) {
				ans = Math.max(ans, A[s.peek()] ^ A[i]);
				if (A[s.peek()] > A[i])
					break;
				else
					s.pop();
			}
			s.push(i);
		}
		return ans;
	}

	//Time-O(n^3)  Space-O(1) 
	private static int maxXorOfMaxAndSecondMaxOfSubarray(int[] A) {
		int n = A.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int xor = findMaxMinSum(A, i, j);
				ans = Math.max(ans, xor);
			}
		}

		return ans;
	}

	private static int findMaxMinSum(int[] A, int s, int e) {
		int largest = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		for (int i = s; i <= e; i++)
			largest = Math.max(largest, A[i]);

		for (int j = s; j <= e; j++)
			if (A[j] != largest)
				second = Math.max(second, A[j]);
		return largest ^ second;
	}

}
