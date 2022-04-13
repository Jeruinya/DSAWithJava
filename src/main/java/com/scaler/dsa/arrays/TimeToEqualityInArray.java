package com.scaler.dsa.arrays;

/**
 * Problem Description
 * Given an integer array A of size N. In one second, you can increase the value
 * of one element by 1.
 * Find the minimum time in seconds to make all elements of the array equal.
 * 
 * Output Format --Return an integer denoting the minimum time to make all elements equal.
 * 
 * Example Explanation--->We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
 */

public class TimeToEqualityInArray {

	public static void main(String[] args) {
		int A[] = { 2, 4, 1, 3, 2 };
		int count = 0;
		int largest = 0;
		for (int i = 1; i < A.length; i++)
			if (A[i] > A[largest])
				largest = i;

		for (int i = 0; i < A.length; i++) {
			while (A[i] < A[largest]) {
				A[i]++;
				count++;
			}
		}

		System.out.println(count);
	}
}
