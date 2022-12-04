package com.scaler.dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description
Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:
	1-All numbers (including target) will be positive integers.
	2-Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
	3-The solution set must not contain duplicate combinations.

Warning:
DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.

Problem Constraints
1 <= N <= 20

Input Format
First argument is an integer array A denoting the collection of candidate numbers.
Second argument is an integer which represents the target number.

Output Format
Return all unique combinations in A where the candidate numbers sums to B.

Input 1:
 A = [10, 1, 2, 7, 6, 1, 5]
 B = 8
Input 2:
 A = [2, 1, 3]
 B = 3

Output 1:
 [ 
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ], 
  [2, 6 ] 
 ]
Output 2:
 [
  [1, 2 ],
  [3 ]
 ]


Explanation 1:
 1 + 1 + 6 = 8
 1 + 2 + 5 = 8
 1 + 7 = 8
 2 + 6 = 8
 All the above combinations sum to 8 and are arranged in ascending order.

Explanation 2:
 1 + 2 = 3
 3 = 3
 All the above combinations sum to 3 and are arranged in ascending order.
 */
public class CombinationSumII {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(10);
		A.add(1);
		A.add(2);
		A.add(7);
		A.add(6);
		A.add(1);
		A.add(5);
		int B = 8;

		System.out.println(combinationSum(A, B));

	}

	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (A.size() == 0)
			return list;

		combinationSum(list, A, new ArrayList<Integer>(), B, 0, 0);
		return list;
	}

	private static void combinationSum(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> input,
			ArrayList<Integer> out, int B, int index, int sum) {
		// Returns if sum exceeds the target value
		if (sum > B) {
			return;
		}
		if (sum == B) {
			// Check if the list already present don't add it again, duplicates lists can
			// come because input list can have duplicate elements
			if (!list.contains(out))
				list.add(new ArrayList<>(out));
			return;
		}

		for (int i = index; i < input.size(); i++) {
			out.add(input.get(i));
			// Don't need to increase the index here as we need all possible sum even if the
			// value is counted multiple times.
			combinationSum(list, input, out, B, i + 1, sum + input.get(i));
			out.remove(out.size() - 1);
		}
	}

}
