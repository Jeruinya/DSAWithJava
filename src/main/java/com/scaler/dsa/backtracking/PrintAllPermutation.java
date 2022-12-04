package com.scaler.dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
1 <= N <= 9

Input Format
Only argument is an integer array A of size N.

Output Format
Return a 2-D array denoting all possible permutation of the array.

Input
A = [1, 2, 3]

Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]


Example Explanation
All the possible permutation of array [1, 2, 3].

Heap’s algorithm is used to generate all permutations of n objects. The idea is to generate each 
permutation from the previous permutation by choosing a pair of elements to interchange, without disturbing the other n-2 elements.

Algorithm:
1)	The algorithm generates (n-1)! permutations of the first n-1 elements, adjoining the last element to each of these. 
    This will generate all of the permutations that end with the last element.

2)  If n is odd, swap the first and last element and if n is even, then swap the ith element 
	(i is the counter starting from 0) and the last element and repeat the above algorithm till i is less than n.

3)  In each iteration, the algorithm will produce all the permutations that end with the current last element.
 */
public class PrintAllPermutation {

	static ArrayList<ArrayList<Integer>> ans;

	public static void main(String[] args) {
		ans= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> A = new ArrayList<>();
		A.add(9);
		//A.add(2);
		//A.add(3);

		ans.add(new ArrayList<Integer>(new ArrayList<>()));
		permute(A, 0, A);

		System.out.println(ans);

	}

	private static void permute(ArrayList<Integer> A, int i, ArrayList<Integer> tempList) {
		if (i == A.size()) {
			ans.add(new ArrayList<Integer>(tempList));
			return;
		}
		for (int j = i; j < A.size(); j++) {
			// DO step
			Collections.swap(tempList, j, i);
			// Recursion call for next index elements - solving subproblem
			permute(A, i + 1, tempList);
			// UNDO step - restore original condition
			Collections.swap(tempList, j, i);
		}
	}
}