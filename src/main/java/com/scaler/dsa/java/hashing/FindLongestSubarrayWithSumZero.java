package com.scaler.dsa.java.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem DescriptionGiven an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.
Problem Constraints
1 <= N <= 106
-107 <= A[i] <= 107
Input Format
Single argument which is an integer array A.
Output Format
Return an array denoting the longest continuous sequence with total sum of zero.

Example Input  A = [1,2,-2,4,-4]
Example Output  [2,-2,4,-4]

Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
A : [ 1, 2, -3, 3 ]--ans--1 2 -3 

Observation:
1: if PS value repeats than there exists a subarray with sum 0.
2:if value repeats at index1 and index2 then s=index1+1 and e= index2.

 */
public class FindLongestSubarrayWithSumZero {

	public static void main(String[] args) {
		int A[] = { 1, 2, -2, 4, -4 };
		int n = A.length;
		int s = -1, e = -1;
		int max = 0;
		Map<Integer, Integer> hm = new HashMap<>();

		int ps[] = new int[n];
		ps[0] = A[0];
		for (int i = 1; i < n; i++)
			ps[i] = ps[i - 1] + A[i];

		for (int i = 0; i < n; i++) {
			if (ps[i] == 0) {
				int newLen = i+1;
				if (newLen>max) {
					max = newLen;
					s = 0;
					e = i;
				}
			} else if (hm.containsKey(ps[i])) {
				if (i - hm.get(ps[i])>max) {
					max = i - hm.get(ps[i]);
					s = hm.get(ps[i]) + 1;
					e = i;
				}
			} else
				hm.put(ps[i], i);
		}
		int l = 0;
		int res[] = new int[0];
		if (s != -1 && e != -1) {
			res = new int[e - s + 1];
			for (int i = s; i <= e; i++)
				res[l++] = A[i];
		}
		System.out.println(Arrays.toString(res));
	}

}
