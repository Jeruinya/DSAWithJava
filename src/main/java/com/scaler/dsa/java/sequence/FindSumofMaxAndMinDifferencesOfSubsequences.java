package com.scaler.dsa.java.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Problem Description
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).
NOTE: Subsequence can be non-contiguous.

Problem Constraints
1 <= N <= 10000
1<= A[i] <=1000
Input Format
First argument is an integer array A.
Output Format
Return an integer denoting the output.
Input 1:A = [1, 2] 
Input 2:A = [1]

Output 1: 1 
Output 2: 0
Explanation 1:
All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1 
Explanation 2:
 Only 1 subsequence of 1 element is formed.
 
 https://www.scaler.com/academy/mentee-dashboard/class/22600/homework/problems/453/hints?navref=cl_pb_nv_tb
 */
public class FindSumofMaxAndMinDifferencesOfSubsequences {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3 };
		int res = printSubsequencesNaive(A);
		System.out.println(res);

		int res1 = solveBetter(A);
		System.out.println(res1);

		int res2 = solveBetter(A);
		System.out.println(res2);

	}

	// TC-O(2^n) , SC-O(1)
	private static int printSubsequencesNaive(int[] A) {
		int n = A.length;
		int num = 0;
		for (int i = 1; i < Math.pow(2, n); i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0)
					list.add(A[j]);
			}
			int sum = findDiff(list);
			num = num + sum;
		}
		return num;

	}

	private static int findDiff(ArrayList<Integer> list) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		if (list.size() == 1)
			max = min = list.get(0);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max)
				max = list.get(i);
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min)
				min = list.get(i);
		}

		return max - min;
	}

	public static long power(int n, int mod) {
		if (n == 0)
			return 1;
		long halfpow = power(n / 2, mod) % mod;
		long fullpow = (1L * halfpow * halfpow) % mod;
		if (n % 2 == 0)
			return fullpow % mod;
		else
			return (fullpow * 2) % mod;
	}

	// TC-O(N^2) SC-O(1)
	public static int solveBetter(int[] A) {
		Arrays.sort(A);
		int n = A.length;
		int mod = 1000000007;
		long num = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				num = (num + (power(j - i - 1, mod) * Math.abs(A[i] - A[j])) % mod) % mod;
			}
		}
		return (int) num;
	}

	// TC-O(N) SC-O(1)
	public static int solveEfficient(ArrayList<Integer> A) {
		Collections.sort(A);
		int Mod = 1000 * 1000 * 1000 + 7;
		long minus = 0, plus = 0;
		for (int i = 0; i < A.size(); i++) {
			int val = A.get(i);
			minus += (val * pow(2, A.size() - 1 - i, Mod)) % Mod;
			minus %= Mod;
			plus += (val * pow(2, i, Mod)) % Mod;
			plus %= Mod;
		}
		return (int) ((plus - minus + Mod) % Mod);
	}

	public static long pow(long x, int y, int k) {
		long result = 1;
		while (y > 0) {
			if (y % 2 == 1) {
				result = (result * x) % k;
				y--;
			}
			y >>= 1;
			x = (x * x) % k;
		}
		return result;
	}
}
