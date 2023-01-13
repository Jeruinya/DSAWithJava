package com.scaler.dsa.pattern;

/*
Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater 
than p in the array equals p.

Input 1: A = [3, 2, 1, 3]
Input 2: A = [1, 1, 3, 3]

Output 1: 1
Output 2: -1
 */
import java.util.Arrays;

public class FindNobleIntegersForGreaterValue {

	public static void main(String[] args) {
		int A[] = { 3, 2, 1, 3 };
		int n = A.length;
		int ans = 0;
		int less = 0;
		Arrays.sort(A);
		reverse(A);
		if (A[0] == 0)
			ans++;
		for (int i = 1; i < n; i++) {
			if (A[i] == A[i - 1])
				continue;
			else
				less = i;
			if (A[i] == less)
				ans++;
		}
		if (ans != 0)
			System.out.println(ans);
		else
			System.out.println(-1);
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
