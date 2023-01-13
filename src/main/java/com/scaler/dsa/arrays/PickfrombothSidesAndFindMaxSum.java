package com.scaler.dsa.arrays;

/*
Problem Description
You are given an integer array A of size N.
You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the 
right end of array A to get the maximum sum.

Find and return this maximum possible sum.
NOTE: Suppose B = 4, and array A contains 10 elements, then
You can pick the first four elements or can pick the last four elements, 
or can pick 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.

Problem Constraints
1 <= N <= 105
1 <= B <= N
-103 <= A[i] <= 103
Input Format
First argument is an integer array A.
Second argument is an integer B.
Output Format
Return an integer denoting the maximum possible sum of elements you picked.

Input 1: A = [5, -2, 3 , 1, 2]  B = 3
Input 2: A = [1, 2]  B = 1

Output 1: 8
Output 2: 2

Explanation 1:
 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get
 
 Approach:
 
 N=5 , A0 A1 A2 A3 A4,   B=3
 
 L		R
 B		0
 B-1	1
 B-2	2
 .
 .
 .
 0		B
 
 Fist find the sum of first B elements in Curr and then add from end and remove from B-1 until B become -1;
 */
public class PickfrombothSidesAndFindMaxSum {

	public static void main(String[] args) {
		int A[] = { 5, -2, 3, 1, 2 }, B = 3;
		int n = A.length;

		System.out.println(findTheLargestSum(A, B, n));

		System.out.println(solve(A, B));

	}

	// TC-O(n)
	private static int findTheLargestSum(int[] A, int B, int n) {
		int ans = Integer.MIN_VALUE;
		int curr = 0;
		for (int i = 0; i < B; i++)
			curr = curr + A[i];

		int back = B - 1;
		ans = Math.max(ans, curr);

		for (int i = n - 1; i >= n - B; i--) {
			curr = curr + A[i];
			curr = curr - A[back];
			back--;
			ans = Math.max(ans, curr);
		}

		return ans;
	}

	public static int solve(int[] A, int B) {
		int n = A.length;
		int[] suff = new int[n + 1];
		suff[n] = 0;
		suff[n - 1] = A[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			suff[i] = A[i] + suff[i + 1];
		}
		int pref_sum = 0;
		int ans = suff[n - B];
		for (int i = 0; i < B; i++) {
			pref_sum = pref_sum + A[i];
			int suff_sum = suff[n - B + (i + 1)];
			ans = Math.max(ans, pref_sum + suff_sum);
		}
		return ans;
	}

}
