package com.scaler.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

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

Observation 1 : Natural Numbers = {1,2,3,4,5,6,7,8,.....} if length of an Array is N then the answer always 
				be 1 <= N+1.
				{1,2,3,4,5} First missing Natural number is 6 here, which is also N+1.

Observation 2 : Finding Range for a missing number will be 1 to N otherwise return N+1 as answer.
       
Special Cases : Negative Natural Number and Duplicate Numbers.

 */
public class FirstMissingInteger {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(0);

		int A[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,20};
		System.out.println(firstMissingPositive(A));

		int res = firstMissingPositive(list);
		System.out.println(res);

	}

	public static int firstMissingPositive(int[] A) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			hs.add(A[i]);
		}

		for (int i = 1; i <= A.length + 1; i++) {
			if (!hs.contains(i)) {
				return i;
			}
		}
		return 0;
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
