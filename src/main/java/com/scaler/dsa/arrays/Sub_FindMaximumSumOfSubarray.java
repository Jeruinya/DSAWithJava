package com.scaler.dsa.arrays;

/*
Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.

Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000

Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.

Input 1:
 A = [1, 2, 3, 4, -10] 
Input 2:
 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 

Output 1: 10 
Output 2: 6 

Explanation 1:
 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:
 The subarray [4,-1,2,1] has the maximum possible sum of 6. 
 
 */

public class Sub_FindMaximumSumOfSubarray {

	public static void main(String[] args) {

		int[] A = { 1, 2, 3, 4, -10 };
		int n = A.length;
		int sum = Integer.MIN_VALUE;// if we assign sum =0 then it will not work as there could be -ve values as
									// well
		int last = 0;
		for (int i = 0; i < n; i++) {
			last += A[i];
			sum = Math.max(last, sum);
			if (last < 0)
				last = 0;
		}

		System.out.println(sum);

	}

}
