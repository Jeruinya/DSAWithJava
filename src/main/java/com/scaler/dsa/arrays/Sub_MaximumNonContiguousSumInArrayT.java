package com.scaler.dsa.arrays;

/**
 * Problem Description
 * You are given an integer array A of size N.
 * You can pick B elements from either left or right end of array A to get the maximum sum.
 * Find and return this maximum possible sum.
 * NOTE: Suppose B = 4, and array A contains 10 elements, then
 * You can pick the first four elements or can pick the last four elements, or
 * can pick 1 from front and 3 from the back, etc. You need to return the
 * maximum possible sum of elements you can pick.
 * Output Format----->Return an integer denoting the maximum possible sum of elements you picked.
 * 
 * Input 1: A = [5, -2, 3 , 1, 2], B = 3
*  Input 2: A = [1, 2], B = 1
*  Example Output
*  Output 1: 8
*  Output 2: 2
 */

public class Sub_MaximumNonContiguousSumInArrayT {

	public static void main(String[] args) {

		int A[] = { 5, -2, 3, 1, 2 };
		int B = 3;
		int n = A.length;
		int ans = maxSumFromEnds(A, B);
		System.out.println(ans);
	}

	public static int maxSumFromEnds(int a[], int b) {
		int n = a.length;
		int i = 0, j = n - 1;
		int sum = 0;
		int b2 = b;
		while (b > 0) {
			sum = sum + a[i++];
			b--;
		}

		int ans = sum;
		while (b2 > 0) {
			sum = sum - a[--i];
			sum = sum + a[j--];
			ans = Math.max(ans, sum);
			b2--;
		}
		return ans;
	}

}