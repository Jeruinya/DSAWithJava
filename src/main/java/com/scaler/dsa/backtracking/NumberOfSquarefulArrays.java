package com.scaler.dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
Problem Description
Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only 
if there is some index i such that A1[i] != A2[i].

Problem Constraints
1 <= length of the array <= 12
1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the number of permutations of A that are squareful.

Input 1: A = [2, 2, 2]
Input 2: A = [1, 17, 8]

Output 1: 1
Output 2: 2

Explanation 1:
 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.

Explanation 2:
 Permutation are [1, 8, 17] and [17, 8, 1].
 */
public class NumberOfSquarefulArrays {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(17);
		A.add(8);
		System.out.println(countSquarefullPermutations(A));

	}

	public static int countSquarefullPermutations(ArrayList<Integer> A) {
		int n = A.size();
		if (n == 1)
			return 0;

		HashSet<ArrayList<Integer>> set = new HashSet<>();
		permutate(A, 0, set);
		System.out.println(set);
		return set.size();
	}

	private static void permutate(ArrayList<Integer> nums, int pos, HashSet<ArrayList<Integer>> set) {
		if (pos == nums.size()) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int n : nums) {
				list.add(n);
			}
			set.add(list);
		}

		for (int i = pos; i < nums.size(); i++) {
			// if(i != pos && nums[i] == nums[pos]) continue;
			// swap(nums, i, pos);
			Collections.swap(nums, i, pos);
			if (pos == 0 || (pos > 0 && checkPerfectSquare(nums.get(pos - 1) + nums.get(pos)))) {
				permutate(nums, pos + 1, set);
			}
			Collections.swap(nums, i, pos);
		}
	}

	private static boolean checkPerfectSquare(int num) {
		double perfectSquare = (double) Math.sqrt(num);
		if (Math.floor(perfectSquare) != Math.ceil(perfectSquare)) {
			return false;
		}
		return true;
	}
}
