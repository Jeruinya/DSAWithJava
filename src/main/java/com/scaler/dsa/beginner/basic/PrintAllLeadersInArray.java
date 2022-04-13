package com.scaler.dsa.beginner.basic;

import java.util.Arrays;

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
