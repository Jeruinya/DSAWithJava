package com.dsa.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description
 * 
 * Given an array of integers A and multiple values in B, which represents the
 * number of times array A needs to be left rotated.
 * Find the rotated array for each value and return the result in the from of a
 * matrix where ith row represents the rotated array for the ith value in B.
 */

public class MultipleLeftRotationOfArray {

	public static void main(String[] args) {

		int A[] = { 1, 2, 3, 4, 5 };
		int B[] = { 2, 3 };

		int res[][] = getAfterleftRotateKtimes(A, B);
		for (int i = 0; i < res.length; i++)
			System.out.println(Arrays.toString(res[i]));

	}

	public static int[][] getAfterleftRotateKtimes(int[] A, int[] B) {
		int res[][] = new int[B.length][B.length];

		int n = A.length;
		for (int i = 0; i < B.length; i++) {
			int mod = B[i] % n;
			int arr[] = new int[n];
			for (int j = 0; j < n; ++j) {
				arr[j] = A[(j + mod) % n];
			}
			res[i] = arr;

		}
		return res;

	}

	public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int n = a.size();
		for (int x : b) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0; i < n; i++)
				temp.add(a.get((i + x) % n));
			ans.add(temp);
		}
		return ans;
	}
}
