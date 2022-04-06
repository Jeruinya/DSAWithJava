package com.dsa.matrix;

import java.util.Arrays;

/**
 * Given an array of integers A, find and return the product array of the same
 * size where the ith element of the product array will be equal to the product
 * of all the elements divided by the ith element of the array.
 * 
 * Note: It is always possible to form the product array with integer (32 bit)
 * values.
 * 
 * For Example
 * Input 1:  A = [1, 2, 3, 4, 5]
 * Output 1:  [120, 60, 40, 30, 24]
 */

public class ProductExceptSelf {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int n = A.length;
		int ans[] = new int[n];
		int prefix[] = new int[n];
		int suffix[] = new int[n];
		prefix[0] = 1;
		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] * A[i - 1];
		}
		suffix[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * A[i + 1];
		}
		for (int i = 0; i < n; i++) {
			ans[i] = prefix[i] * suffix[i];
		}
		System.out.println(Arrays.toString(ans));
	}

}