package com.scaler.dsa.java.hashing;

/*
Problem Description
Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
If there is no repeating element, return -1.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
The first and only argument is an integer array A of size N.
Output Format
Return an integer denoting the first repeating element.

Input 1: A = [10, 5, 3, 4, 3, 5, 6]
Input 2: A = [6, 10, 5, 4, 9, 120]

Output 1: 5
Output 2: -1

Explanation 1:
 5 is the first element that repeats
Explanation 2:
 There is no repeating element, output -1
 */
import java.util.HashMap;

public class FindFirstRepeatingElementInArray {

	public static void main(String[] args) {
		int A[] = { 10, 5, 3, 4, 3, 5, 6 };
		System.out.println(findFistRepeatedElem(A));

	}

	private static int findFistRepeatedElem(int[] A) {
		int res = -1;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);
			else
				hm.put(A[i], 1);
		}
		for (int i = 0; i < A.length; i++) {
			if (hm.get(A[i]) > 1) {
				res = A[i];
				break;
			}
		}
		return res;
	}
}
