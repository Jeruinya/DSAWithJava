package com.scaler.dsa.java.hashing;

/*
Given N array elements , check if there exists a subarray with sum zero.

How we can conclude that a array contains a subarray with sum zero?
Ans--We will prepare a prefix array and if in that prefix if some element repeats of it have a zero value element than we can say that the
array contains a subarray with sum zero.
Becasue  ps[e]-ps[s-1]=0=====> ps[e]=ps[s-1]

A=	 {2,2,1,-3,4,3,1,-2,-3,2}
ps[]={2,4,5,2,6,9,10,8,5,7}

Brute force---> 1--For each subarray calculate the sum and check O(N^3)  2--Build prefix array and find the sum =ps[end]-ps[start-1] and check O(N^2) & O(n)

ps[e]-ps[start-1]=0
ps[e]=ps[start-1]

Observation 1--if prefix value repeats then there exists a subarray with sum zero.
Observation 2--if the value repeats at index1 and index2 then s=index1+1 and e= index2;


 */
import java.util.HashSet;

public class SubarrayWithZeroSum {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 3, 9, -4, -6, 7, -1 };
		int n = arr.length;

		System.out.println(ZeroSumSubarray(arr, n));

		System.out.println(ZeroSumSubarrayPrefixSum(arr, n));
	}

	// O(N) and O(n) solution
	private static boolean ZeroSumSubarrayPrefixSum(int[] A, int n) {
		int ps[] = new int[n];
		ps[0] = A[0];
		for (int i = 1; i < n; i++)
			ps[i] = ps[i - 1] + ps[i];
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (hs.contains(ps[i]))
				return true;
			else
				hs.add(ps[i]);
		}
		if (hs.contains(0))
			return true;

		return false;
	}

	// O(N) and O(1) solution
	static int ZeroSumSubarray(int A[], int n) {
		HashSet<Long> hs = new HashSet<>();
		long sum = 0;
		//hs.add(0l);
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
			if (hs.contains(sum))
				return 1;
			else
				hs.add(sum);
		}
		if(hs.contains(0l))
			return 1;

		return 0;
	}
}