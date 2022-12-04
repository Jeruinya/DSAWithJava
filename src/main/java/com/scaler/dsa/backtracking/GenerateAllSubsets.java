package com.scaler.dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description
Given a set of distinct integers A, return all possible subsets.

NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.

Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX

Input Format
First and only argument of input contains a single integer array A.

Output Format
Return a vector of vectors denoting the answer.

Input 1:A = [1]
Input 2:A = [1, 2, 3]

Output 1:
[
    []
    [1]
]
Output 2:
[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]

Explanation 1:
 You can see that these are all possible subsets.

Explanation 2:
You can see that these are all possible subsets.
 */
public class GenerateAllSubsets {

	static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(13);

		ArrayList<ArrayList<Integer>> res = subsets(list);
		System.out.println(res);

	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		Collections.sort(A);
		ans = new ArrayList<>();
		ArrayList<Integer> cur = new ArrayList<>();
		solve(0, cur, A);
		// sort the list of list
		Collections.sort(ans, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
			for (int i = 0; i < first.size() && i < second.size(); i++) {
				if (first.get(i) < second.get(i))
					return -1;
				if (first.get(i) > second.get(i))
					return 1;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});
		return ans;
	}

	static void solve(int i, ArrayList<Integer> cur, ArrayList<Integer> A) {
		if (i == A.size()) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		solve(i + 1, cur, A); // not take
		int element = A.get(i);
		cur.add(element); // DO
		solve(i + 1, cur, A); // take
		cur.remove(cur.size() - 1); // UNDO
	}

}
