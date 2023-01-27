package com.scaler.dsa.java.hashing;

import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an
 array with a single element "-1".

Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110

Output 1: [2, 3]
Output 2: -1

Explanation 1:
 [2, 3] sums up to 5.
Explanation 2:
 No subarray sums up to required number.
 */

public class LongestSubarrayWithGivenSumK {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int K = 5;
		System.out.println(Arrays.toString(longestSubarrayWithSumK(A, K)));

	}

	private static int[] longestSubarrayWithSumK(int[] A, int K) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		int s = 0, e = -1;
		int maxLen = 0;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
			if (sum - K == 0) {
				int len = i + 1;
				if (maxLen < len) {
					maxLen = len;
					s = 0;
					e = i;
				}
			}
			else if (hm.containsKey(sum - K)) {
				int len = i - hm.get(sum - K);
				if (maxLen < len) {
					maxLen = len;
					s = hm.get(sum - K) + 1;
					e = i;
				}
			} else
				hm.put(sum, i);
		}
		int arr[] = new int[0];
		if (e != -1) {
			arr = new int[e - s + 1];
			int c = 0;
			for (int i = s; i <= arr.length; i++)
				arr[c++] = A[i];
		}
		return arr;
	}

}
