package com.scaler.dsa.maths;

/*
Problem Description
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) 
of the remaining array is maximum.
Find the maximum value of GCD.
Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109
Input Format
First argument is an integer array A.
Output Format
Return an integer denoting the maximum value of GCD.

Input 1: A = [12, 15, 18]
Input 2: A = [5, 15, 30]
Output 1: 6
Output 2: 15

Explanation 1: 
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:
 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 
 
Given an array, we can delete 1 element from the array, and take gcd of remaining elements. 
Find the max gcd we can generate by removing 1 element from the array. Duplicates can be present.

A[]={24,16,18,30,15}

efficient approach:
Build Prefix GCD and suffix GCD.

prefixGcd[i]= gcd of all the elements from [0-i]
suffixGcd[i]= gcd of all the elements from [i+1,n-1]
 */
public class GivenArrayRemoveOneElementAndTakeGCD {

	public static void main(String[] args) {
		int A[] = { 24, 16, 18, 30, 15 };
		int maxGcd = getMaxGcd(A);
		System.out.println(maxGcd);

		int maxGcdEfficient = getMaxGcdEfficient(A);
		System.out.println(maxGcdEfficient);

	}

	private static int getMaxGcdEfficient(int[] A) {
		int n = A.length;
		int prefixGcd[] = new int[n];
		int suffixGcd[] = new int[n];

		prefixGcd[0] = A[0];
		for (int i = 1; i < n; i++)
			prefixGcd[i] = getGcd(prefixGcd[i - 1], A[i]);

		suffixGcd[n - 1] = A[n - 1];
		for (int i = n - 2; i >= 0; i--)
			suffixGcd[i] = getGcd(suffixGcd[i + 1], A[i]);

		int ans =Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int leftGcd=0;
			int rightGcd=0;
			if (i!= 0)
				leftGcd = prefixGcd[i - 1];
			if (i!= n - 1)
				rightGcd = suffixGcd[i + 1];
			int currGcd = getGcd(leftGcd, rightGcd);
			ans = Math.max(currGcd,ans);
		}

		return ans;
	}

	private static int getMaxGcd(int[] A) {
		int ans = 0;
		int gcd = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i != j) {
					gcd = getGcd(gcd, A[j]);
				}
			}
			ans = Math.max(ans, gcd);
			gcd = 0;
		}
		return ans;
	}

	private static int getGcd(int a, int b) {
		int a1, b1;
		while (a != 0) {
			a1 = b % a;
			b1 = a;
			a = a1;
			b = b1;
		}
		return b;
	}

}
