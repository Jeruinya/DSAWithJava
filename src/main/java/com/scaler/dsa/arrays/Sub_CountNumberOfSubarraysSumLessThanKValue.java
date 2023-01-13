package com.scaler.dsa.arrays;

public class Sub_CountNumberOfSubarraysSumLessThanKValue {

	public static void main(String[] args) {
		int A[] = { 1, 11, 2, 3, 15 };
		int B = 10;
		System.out.println(numberOfSubarraysLessThanB(A, B));
	}

	public static int numberOfSubarraysLessThanB(int[] A, int B) {
		int n = A.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				if (sum < B)
					count++;
			}
		}
		return count;
	}
}