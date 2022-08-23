package com.scaler.dsa.binarySearch;

/*
Google Interview Problem
There are N stacks of coins, each stack has certain value of coins.
The stacks are lying on a straight line, you have K friends with who you can divide the 
stacks in K+1 partitions. Your friends are greedy and they will pick the best K parts 
and you will give the left one. Maximize the value of coins you can get.

A[]={10,20,15,5,8}
search space will be from 0 to sum of array
 */
public class NStacksOfCoins {

	public static void main(String[] args) {
		int A[] = { 10, 20, 15, 5, 8 };
		int k = 3;
		System.out.println(maximizeTheValue(A, k));

	}

	private static int maximizeTheValue(int[] A, int k) {
		int sum = 0;
		for (int i : A)
			sum += i;
		int s = 0;
		int e = sum;
		int ans = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (canDivide(A, mid, k)) {
				ans = mid;
				s = mid + 1;
			} else
				e = mid - 1;
		}
		return ans;
	}

	private static boolean canDivide(int[] A, int mid, int k) {
		int count = 0;
		int t = 0;
		for (int i = 0; i < A.length; i++) {
			if (t + A[i] >= mid) {
				count++;
				t = 0;
			} else
				t = t + A[i];
		}
		if (count > k)
			return true;
		return false;
	}

}
