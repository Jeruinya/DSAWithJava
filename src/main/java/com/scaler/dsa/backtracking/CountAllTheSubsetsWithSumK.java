package com.scaler.dsa.backtracking;

import java.util.ArrayList;

/*
Given an array of size n, count all the subsets with sum k.
A[]={1,1,5,2,7,0} k=9.
 */
public class CountAllTheSubsetsWithSumK {
	static ArrayList<ArrayList<Integer>> ans;

	public static void main(String[] args) {
		//int A[] = { 1, 1, 5, 2, 7, 0 };
		int A[]= {2,7,-2,2};
		int k = 9;
		ArrayList<Integer> list = new ArrayList<>();
		ans = new ArrayList<>();
		System.out.println(countAllSubsets(A, 0, 0, k, list));
		System.out.println(ans);

	}

	private static int countAllSubsets(int[] input, int i, int currSum, int k, ArrayList<Integer> list) {
		// When array is finished
		if (i == input.length) {
			if (currSum == k) {
				ans.add(new ArrayList<Integer>(list));
				return 1;
			} else
				return 0;
		}
		// when currSum greater than k the prone the search space
		if (currSum > k)
			return 0;
		
		list.add(input[i]);
		int x = countAllSubsets(input, i + 1, currSum + input[i], k, list);
		list.remove(list.size()-1);
		int y = countAllSubsets(input, i + 1, currSum, k, list);
		return x + y;
	}

}
