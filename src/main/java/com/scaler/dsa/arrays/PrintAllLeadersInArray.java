package com.scaler.dsa.arrays;

import java.util.Arrays;

/*
Problem Description

Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
An element is a leader if it is strictly greater than all the elements to its right side.
NOTE:The rightmost element is always a leader.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108
Input Format
First and only argument is an integer array A.
Output Format
Return an integer array denoting all the leader elements of the array.
NOTE: Ordering in the output doesn't matter.
Input 1: A = [16, 17, 4, 3, 5, 2]
Input 2: A = [1, 2]

Output 1: [17, 2, 5]
Output 2: [2]


Explanation 1:
 Element 17 is strictly greater than all the elements on the right side to it.
 Element 2 is strictly greater than all the elements on the right side to it.
 Element 5 is strictly greater than all the elements on the right side to it.
 So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.

Explanation 2:
 Only 2 the rightmost element is the leader in the array.
 */
public class PrintAllLeadersInArray {

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		int leaders[] = findLeadersNaive(arr, arr.length);
		System.out.println(Arrays.toString(leaders));

		int arr1[] = { 16, 17, 4, 3, 5, 2 };
		int leaders1[] = findLeadersEfficient(arr1, arr1.length);
		System.out.println(Arrays.toString(leaders1));

	}

	private static int[] findLeadersEfficient(int[] A, int n) {
		int cur_leader = A[n - 1];
		int count = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (cur_leader < A[i]) {
				cur_leader = A[i];
				count++;
			}
		}
		int leaders[] = new int[count];
		leaders[0] = A[n - 1];
		int cur_leader1 = A[n - 1];
		int k = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (cur_leader1 < A[i]) {
				cur_leader1 = A[i];
				leaders[k++] = A[i];
			}
		}
		return leaders;

	}

	private static int[] findLeadersNaive(int[] arr, int n) {
		int leaders[] = new int[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] <= arr[j]) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				leaders[k++] = arr[i];
			}
		}
		return leaders;
	}

}
