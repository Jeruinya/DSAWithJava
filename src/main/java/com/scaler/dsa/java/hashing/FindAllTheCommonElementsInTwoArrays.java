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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllTheCommonElementsInTwoArrays {

	public static void main(String[] args) {
		int A[] = { 17, 12, 5, 3, 14, 13, 3, 2 };
		int B[] = { 19, 16, 8, 7, 12, 19, 10, 13, 8, 20, 16, 15, 4, 12, 3, 14, 14 };

		HashMap<Integer, Integer> hma = new HashMap<>();
		List<Integer> l = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			if (hma.containsKey(A[i]))
				hma.put(A[i], hma.get(A[i]) + 1);
			else
				hma.put(A[i], 1);
		}
		for (int i = 0; i < B.length; i++) {
			if (hma.containsKey(B[i]) && hma.get(B[i]) > 0) {
				l.add(B[i]);
				hma.put(B[i], hma.get(B[i]) - 1);
			}
		}

		int arr[] = new int[l.size()];
		arr = l.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
		System.out.println(Arrays.toString(arr));
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
