package com.scaler.dsa.arrays;

/**
 * Problem Description You are given an integer array A.
 * Decide whether it is possible to divide the array into one or more subarrays
 * of even length such that the first and last element of all subarrays will be even.
 * Return "YES" if it is possible; otherwise, return "NO" (without quotes).
 */
public class FindNumberOfSubarraysOfEvenLengthT {

	public static void main(String[] args) {
		int[] A = {4, 5, 3, 8 };
		int n=A.length;
		if(A[0]%2==0 && A[n-1]%2==0 && n%2==0)
			System.out.println("YES");
		else 
			System.out.println("NO");
	}
}
