package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

Input 1: A = [1, 2, 3, 4, 5]   B = 5
Input 2: A = [5, 10, 20, 100, 105]   B = 110
Output 1: [2, 3]
Output 2: -1

Explanation 1: [2, 3] sums up to 5.
Explanation 2: No subarray sums up to required number.

Observations for Hashing--->
1-check whether curr_sum-sum=0, if it is zero means the subarray is starting from zero  so stop.
2-if hashMap already has the value means we already have the subarray with the sum so stop. 
 */
public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int B = 5;

		int arr[] = subarraySumNaive(A, B);
		System.out.println(Arrays.toString(arr));

		int arr1[] = subarraySumEfficient(A, B);
		System.out.println(Arrays.toString(arr1));

		int arr2[] = subarraySumEfficientHashing(A, B);
		System.out.println(Arrays.toString(arr2));
	}

	public static int[] subarraySumEfficientHashing(int[] A, int B) {
		long curr_sum = 0;
		int s = 0, e = -1;
		int temp[] = new int[0];

		Map<Long, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			curr_sum = curr_sum + A[i];
			if (curr_sum - B == 0) {
				s = 0;
				e = i;
				break;
			}
			if (hm.containsKey(curr_sum - B)) {
				s = hm.get(curr_sum - B) + 1;
				e = i;
				break;
			}
			hm.put(curr_sum, i);
		}
		if (e == -1) {
			temp = new int[1];
			temp[0] = -1;
			return temp;
		} else {
			int c = 0;
			temp = new int[e - s + 1];
			for (int k = s; k <= e; k++)
				temp[c++] = A[k];
		}

		return temp;
	}

	// TC-O(N^2) SC-O(N)
	private static int[] subarraySumNaive(int[] A, int B) {
		int n = A.length;
		int i, j;
		int len = 0;
		int temp[] = new int[0];

		for (i = 0; i < n; i++) {
			int sum = 0;
			for (j = i; j < n; j++) {
				sum = sum + A[j];
				if (sum == B) {
					len = j - i + 1;
					temp = new int[len];
					int c = 0;
					for (int k = i; k <= j; k++)
						temp[c++] = A[k];
					return temp;
				}
			}
		}
		if (n == 0) {
			temp = new int[1];
			temp[0] = -1;
		}
		return temp;
	}

	// TC-O(N) SC-O(N)
	private static int[] subarraySumEfficient(int[] A, int B) {
		int start = 0, i = 0;
		List<Integer> list = new ArrayList<>();
		int sum = A[0];
		for (i = 1; i < A.length; i++) {
			while (sum > B && start < i) {
				sum = sum - A[start];
				start++;
			}
			if (sum == B) {
				for (int k = start; k < i; k++) {
					list.add(A[k]);
				}
				break;
			}
			if (i < A.length)
				sum = sum + A[i];
		}
		int n = list.size();
		if (n == 0) {
			int t[] = new int[1];
			t[0] = -1;
			return t;
		}
		int temp[] = new int[n];
		temp = list.stream().mapToInt(x -> x).toArray();

		return temp;
	}
}