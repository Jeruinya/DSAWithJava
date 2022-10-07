package com.scaler.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/*
Given N array elements, find the sum of maximum of every subarray.

A[]={1,4,3}

{1}		1
{1,4}	4
{1,4,3} 4
{4}		4
{4,3}	4
{3}		3
-------------
sum=	20
 */
public class FindSumOfMaxOfAllTheSubarrays {

	public static void main(String[] args) {
		int A[] = { 1, 4, 3 };

		System.out.println(findMaxOfEverySubarrayNaive(A));
		System.out.println(findMaxOfEverySubarrayEff(A));

	}

	private static int findMaxOfEverySubarrayEff(int[] A) {
		int n = A.length;
		// pre-compute all of this
		int[] prevGreater = prevGreaterIndex(A);
		int[] nextGreater = nextGreaterIndex(A);
		int mod = 1000 * 1000 * 1000 + 7;

		long ans = 0;
		for (int i = 0; i < A.length; i++) {

			// subarray in which A[i] is max
			int p3 = prevGreater[i];
			int p4 = nextGreater[i];
			long prodMax = (1L * (i - p3) * (p4 - i)) % mod;
			long maxContribution = (prodMax * A[i]) % mod;

			// computing ans
			ans = (ans % mod) + ((maxContribution) % mod);
			ans = ans % mod;
		}
		if (ans < 0) {
			ans = (ans + mod) % mod;
		}
		return (int) (ans % mod);
	}

	private static int[] prevGreaterIndex(int[] A) {
		int N = A.length;
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}

	private static int[] nextGreaterIndex(int[] A) {
		int N = A.length;
		int[] ans = new int[N];
		Arrays.fill(ans, N); // edge case
		Stack<Integer> stack = new Stack<>();

		for (int i = N - 1; i >= 0; i--) {
			while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}

	private static int findMaxOfEverySubarrayNaive(int[] A) {
		int n = A.length;
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++)
				ans = ans + findMaxMinSum(A, i, j);

		return ans;
	}

	private static int findMaxMinSum(int[] A, int s, int e) {
		int max = Integer.MIN_VALUE;

		for (int i = s; i <= e; i++)
			if (A[i] > max)
				max = A[i];

		return max;
	}

}
