package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Problem Description
Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.
Find the minimum cost to remove all elements from the array.

Input 1: A = [2, 1]
Input 2: A = [5]
Output 1: 4
Output 2: 5

Explanation 1:
 Given array A = [2, 1]
 Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
 Remove 1 from the array => []. Cost of this operation is (1) = 1.
 So, total cost is = 3 + 1 = 4.

Explanation 2:
 There is only one element in the array. So, cost of removing is 5.
 */
public class MinimumCostOfRemoval {

	public static void main(String[] args) {
		int A[] = { 2, 1 };
		Arrays.sort(A);
		reverse(A);
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			ans = ans + A[i] * (i + 1);
		}
		System.out.println(ans);
	}

	public static void reverse(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - i - 1];
			arr[n - i - 1] = temp;
		}
	}
}
