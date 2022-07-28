package com.scaler.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
1 <= N <= 1000000
-109 <= A[i] <= 109
Input Format
First argument is an integer array A.
Output Format
Return an integer denoting the first missing positive integer.

Input 1:[1, 2, 0]
Input 2:[3, 4, -1, 1]
Input 3:[-8, -7, -6]

Output 1:3
Output 2:2
Output 3:1

Explanation 1:A = [1, 2, 0]
First positive integer missing from the array is 3.
 */
public class FirstMissingInteger {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(0);

		int res = firstMissingPositive(list);
		System.out.println(res);

	}

	public static int firstMissingPositive(ArrayList<Integer> A) {
		int n = A.size();
		for (int i = 0; i < n; i++) {
			if (A.get(i) > 0 && A.get(i) <= n) {
				int pos = A.get(i) - 1;
				if (A.get(pos) != A.get(i)) {
					Collections.swap(A, pos, i);
					i--;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (A.get(i) != i + 1)
				return (i + 1);
		}
		return n + 1;
	}
}
