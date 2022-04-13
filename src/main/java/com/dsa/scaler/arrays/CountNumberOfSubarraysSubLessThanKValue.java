package com.dsa.scaler.arrays;

public class CountNumberOfSubarraysSubLessThanKValue {

	public static void main(String[] args) {
		int A[] = { 1, 11, 2, 3, 15 };
		int B = 10;
		int count = numberOfSubarraysLessThanB(A, B);
		System.out.println(count);
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