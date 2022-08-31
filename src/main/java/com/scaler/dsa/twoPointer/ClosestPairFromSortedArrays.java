package com.scaler.dsa.twoPointer;

import java.util.Arrays;

/*
Problem Description
Given two sorted arrays of distinct integers, A and B, and an integer C, 
find and return the pair whose sum is closest to C and the pair has one element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
If there are multiple solutions find the one with minimum i and even if there are multiple 
values of j for the same i then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.

Problem Constraints
1 <= length of both the arrays <= 100000
1 <= A[i], B[i] <= 109
1 <= C <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.
The third argument given is integer C.

Output Format
Return an array of size 2 denoting the pair which has sum closest to C.

Input 1:
 A = [1, 2, 3, 4, 5]
 B = [2, 4, 6, 8]
 C = 9
Input 2:
 A = [5, 10, 20]
 B = [1, 2, 30]
 C = 13

Output 1: [1, 8]
Output 2: [10, 2]

Explanation 1:
 There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].

Explanation 2:
 [10, 2] is the only pair such abs(10+2-13) is minimum.
 */
public class ClosestPairFromSortedArrays {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int[] B = { 2, 4, 6, 8 };
		int C = 9;
		int res1[] = closestPairNaive(A, B, C);
		int res2[] = closestPairEff(A, B, C);
		int res3[] = closestPairMoreEff(A, B, C);

		System.out.println(Arrays.toString(res1));
		System.out.println(Arrays.toString(res2));
		System.out.println(Arrays.toString(res3));
	}

	// TC -O(n+m)
	public static int[] closestPairMoreEff(int[] a, int[] b, int c) {
		int n = a.length, m = b.length;
		int l = 0, r = m - 1;
		long dif = (long) (2e9);
		int ans[] = new int[] { -1, -1 };
		while (l < n && r >= 0) {
			if (Math.abs(a[l] + b[r] - c) < dif) {
				dif = Math.abs(a[l] + b[r] - c);
				ans[0] = a[l];
				ans[1] = b[r];
			} else if (Math.abs(a[l] + b[r] - c) == dif && ans[0] == a[l]) {
				ans[1] = b[r];
			}
			if (a[l] + b[r] >= c)
				r--;
			else
				l++;
		}
		return ans;
	}

	// TC-O(n+m) Space- O(n+m) but code is not working currently
	public static int[] closestPairEff(int[] A, int[] B, int C) {
		int n = A.length, m = B.length;

		int i = 0, j = 0, k = 0;

		int D[] = new int[n + m];
		int res[] = new int[2];
		while (i < n && j < m) {
			if (A[i] < B[j]) {
				D[k] = A[i];
				k++;
				i++;
			} else {
				D[k] = B[j];
				k++;
				j++;
			}
		}
		while (i < n) {
			D[k] = A[i];
			i++;
			k++;
		}

		while (j < m) {
			D[k] = B[j];
			j++;
			k++;
		}

		int x1 = 0;
		int x2 = D.length - 1;
		int diff = Integer.MAX_VALUE;

		while (x1 < n && x2 >= 0) {
			if (Math.abs(D[x1] + D[x2] - C) < diff) {
				diff = Math.abs(D[x1] + D[x2] - C);
				res[0] = D[x1];
				res[1] = D[x2];
			} else if (Math.abs(D[x1] + D[x2] - C) == diff && res[0] == D[x1]) {
				res[1] = D[x2];
			}
		  if(D[x1] + D[x2] >= C)
				x2--;
			else
				x1++;
		}

		return res;
	}

	public static int[] closestPairNaive(int[] A, int[] B, int C) {
		int n = A.length;
		int m = B.length;

		int x = 0;
		int y = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((Math.abs((A[i] + B[j]) - C)) < (Math.abs((A[x] + B[y]) - C))) {
					x = i;
					y = j;
				}
			}
		}
		int res[] = new int[2];
		res[0] = A[x];
		res[1] = B[y];
		return res;
	}
}
