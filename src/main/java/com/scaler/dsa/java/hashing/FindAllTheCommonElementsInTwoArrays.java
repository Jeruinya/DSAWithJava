package com.scaler.dsa.java.hashing;

/*
Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:
Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.
Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109

Input Format
First argument is an integer array A of size N.
Second argument is an integer array B of size M.

Output Format
Return an integer array denoting the common elements.

Input 1:
 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:
 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]

Output 1: [1, 2, 2]
Output 2: [2, 10]
Explanation 1:
 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:
 Elements (2, 10) appears in both the array.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class FindAllTheCommonElementsInTwoArrays {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(2);
		list1.add(1);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list2.add(1);
		list2.add(2);
		System.out.println(solve(list1, list2));

	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> l = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			if (hm.containsKey(A.get(i)))
				hm.put(A.get(i), hm.get(A.get(i)) + 1);
			else
				hm.put(A.get(i), 1);
		}
		for (int i = 0; i < B.size(); i++) {
			if (hm.containsKey(B.get(i)) && hm.get(B.get(i)) > 0) {
				l.add(B.get(i));
				hm.put(B.get(i), hm.get(B.get(i)) - 1);
			}
		}

		return l;
	}
}
