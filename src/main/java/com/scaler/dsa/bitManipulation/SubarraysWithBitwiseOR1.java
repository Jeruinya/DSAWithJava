package com.scaler.dsa.bitManipulation;

/*
Problem Description
Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.

Input Format:
The first argument is a single integer A.
The second argument is an integer array B.

Output Format:
Return the number of subarrays with bitwise array 1.

Input 1: A = 3,B = [1, 0, 1]
Input 2: A = 2,B = [1, 0]

Output 1:5
Output2:2

Explanation 1:
The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1

Explanation 2:
The subarrays are :- [1], [0], [1, 0]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1
 */
public class SubarraysWithBitwiseOR1 {

	public static void main(String[] args) {
		int B[] = { 1, 0, 1 };
		int A = 3;
		int count = numberOfSubarraysWithOR1Naive(B, A);
		System.out.println(count);

		long count1 = numberOfSubarraysWithOR1Efficient(B, A);
		System.out.println(count1);
	}

	private static long numberOfSubarraysWithOR1Efficient(int[] B, int A) {
		long count = 0;
		long last = 0;
		for (int i = 0; i < A; i++) {
			if (B[i] == 1) 
				last = i + 1;
			count = count + last;
		}
		return count;
	}

	private static int numberOfSubarraysWithOR1Naive(int[] B, int A) {
		int count = 0;
		for (int i = 0; i < A; i++) {
			int res = 0;
			for (int j = i; j < A; j++) {
				res = res | B[j];
				if (res > 0)
					count++;
			}
		}
		return count;
	}

}
