package com.scaler.dsa.java.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description

Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 < index2. Please note that your returned answers (both index1 and index2 )
are not zero-based. Put both these numbers in order in an array and return the array from your function 
(Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. 
If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
 */
public class PairsWithGivenSumInArray {

	public static void main(String[] args) {
		int A[] = new int[] { 3, 8, 4, 7, 6, 1 };
		int x = 14;
		System.out.println(Arrays.toString(twoSum(A, x)));
	}

	public static int[] twoSum(final int[] A, int B) {
		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(B - A[i]))
				return new int[] { hm.get(B - A[i]), i };
			else if (!hm.containsKey(A[i]))
				hm.put(A[i], i);
		}
		return new int[0];
	}
}