package com.scaler.dsa.arrays;

/*
  Problem Description You are given an integer array A of length N. You have to
  find the sum of all subarray sums of A. More formally, a subarray is defined
  as a contiguous part of an array which we can obtain by deleting zero or more
  elements from either end of the array. A subarray sum denotes the sum of all
  the elements of that subarray.
  
  Output Format--->Return a single integer denoting the sum of all subarray sums of the given array.
  
A=[10,20,30]

S		E		Sum
0		0		10			A[0]
0		1		30			A[0]+A[1]
0		2		60			A[0]+A[1]+A[2]
1		1		20			A[1]
1		2		50			A[1]+A[2]
2		2		30			A[2]

Sum= 3*A[0] +4*A[1] + 3*A[2]

Here multiplier is the number of subarrays where that element is present.

A[]=[10,20,30,40]  , how many subarrays does A[2] occur in the array

S		E
0		2
0		3
1		2
1		3
2		2
2		3

So A[2] occurs in 6 subarrays.



 */

public class Sub_SumOfAllSubarrays {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3 };

		System.out.println(subarraySum(A));
	}

	public static long subarraySum(int[] A) {
		int n = A.length;
		long ans = 0;
		for (int i = 0; i < n; i++)
			ans = ans + (long) A[i] * (i + 1) * (n - i);

		return ans;
	}
}
