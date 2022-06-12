package com.scaler.dsa.java.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithGivenSumPresent {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 8, 6, 13, 3, -1 };
		int sum = 22;
		int n = arr.length;
		System.out.println(isSum(arr, n, sum));
		System.out.println(isSumEfficient(arr, n, sum));
	}

	static boolean isSumEfficient(int arr[], int n, int sum) {
		Set<Integer> hs = new HashSet<Integer>();
		int pre_sum = 0;
		for (int i = 0; i < n; i++) {
			if (pre_sum == sum)
				return true;
			pre_sum += arr[i];
			if (hs.contains(pre_sum - sum))
				return true;

			hs.add(pre_sum);
		}

		return false;
	}
	
	static boolean isSum(int arr[], int n, int sum) {
		for (int i = 0; i < n; i++) {
			int curr_sum = 0;
			for (int j = i; j < n; j++) {
				curr_sum += arr[j];
				if (curr_sum == sum)
					return true;
			}
		}
		return false;
	}

}
