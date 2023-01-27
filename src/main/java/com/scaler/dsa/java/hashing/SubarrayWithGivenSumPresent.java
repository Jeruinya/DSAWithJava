package com.scaler.dsa.java.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithGivenSumPresent {

	public static void main(String[] args) {
		int A[] = new int[] { 5, 8, 6, 13, 3, -1 };
		int sum = 22;
		System.out.println(isSum(A, sum));
		System.out.println(isSumEfficient(A, sum));
	}

	static boolean isSumEfficient(int A[], int sum) {
		Set<Integer> hs = new HashSet<Integer>();
		int n = A.length;
		int pre_sum = 0;
		for (int i = 0; i < n; i++) {
			if (pre_sum == sum)
				return true;
			pre_sum += A[i];
			if (hs.contains(pre_sum - sum))
				return true;

			hs.add(pre_sum);
		}

		return false;
	}

	static boolean isSum(int A[], int sum) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int curr_sum = 0;
			for (int j = i; j < n; j++) {
				curr_sum += A[j];
				if (curr_sum == sum)
					return true;
			}
		}
		return false;
	}

}
