package com.scaler.dsa.twoPointer;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description

Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
Find all unique triplets in the array which gives the sum of zero.
Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) 
The solution set must not contain duplicate triplets.

Problem Constraints
0 <= N <= 7000
-108 <= A[i] <= 108

Input Format
Single argument representing a 1-D array A.

Output Format
Output a 2-D vector where each row represent a unique triplet.

Example Input
A = [-1,0,1,2,-1,4]

Example Output

[ [-1,0,1],
  [-1,-1,2] ]


Example Explanation
Out of all the possible triplets having total sum zero,only the above two triplets are unique.
 */
public class SumZeroTriplet {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(-1);
		list.add(4);
		System.out.println(threeSum(list));

	}

	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

		int n = A.size();
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		for (int k = 0; k < n - 2; k++) {
			int i = k + 1;
			int j = n - 1;
			while (i < j) {
				int sum = A.get(i) + A.get(j);

				if (sum == -(A.get(k))) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(A.get(k));
					list.add(A.get(i));
					list.add(A.get(j));

					if (!ans.contains(list)) {
						ans.add(list);
					}
					i++;
					j--;

				} else if (sum > -(A.get(k)))
					j--;
				else
					i++;
			}
		}
		return ans;
	}
}