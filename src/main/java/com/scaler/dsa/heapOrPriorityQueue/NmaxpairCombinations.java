package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem Description
Given two integers arrays, A and B, of size N each.
Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in arrays A and B.

Problem Constraints
1 <= N <= 2 * 105
-1000 <= A[i], B[i] <= 1000

Input Format
The first argument is an integer array A.
The second argument is an integer array B.

Output Format
Return an integer array denoting the N maximum element in descending order.

Input 1:
 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
Input 2:
 A = [2, 4, 1, 1]
 B = [-2, -3, 2, 4]

Output 1: [10, 9, 9, 8]
Output 2: [8, 6, 6, 5]

Explanation 1:
 4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).

Explanation 2:
 4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).
 */
public class NmaxpairCombinations {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(3);

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(5);
		list1.add(1);
		list1.add(6);

		System.out.println(findPairs(list, list1));

	}

	//Time -O(n^2+ nlogn)=> O(N^2) , Space= O(N^2)
	private static List<Integer> findPairs(ArrayList<Integer> A, ArrayList<Integer> B) {
		List<Integer> list = new ArrayList<Integer>();
		int n = A.size();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
					list.add(A.get(i) + B.get(j));
		
		list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		ArrayList<Integer> ans= new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			ans.add(list.get(i));
		return ans;
	}

}
