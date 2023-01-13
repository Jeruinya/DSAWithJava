package com.scaler.dsa.arrays;

/*
Problem Description Given an array of size N, find the subarray of size K
with the least average.
 
Input Format :First argument contains an array A of integers of size N.Second argument contains integer k.
 
Output Format : Return the index of the first element of the subarray of size k that has least average.Array indexing starts from 0.

Input 1:
A=[3, 7, 90, 20, 10, 50, 40]
B=3

Input 2:
A=[3, 7, 5, 20, -10, 0, 12]
B=2

Output 1:3
Output 2:4

Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.

Explanation 2:
 Subarray between [4, 5] has minimum average



start index could be 0,1,2,3,4,......n-k;
here initial start index is 0 and we will update as if we find a subarray with minimum value later.

Hint:
Average for any particular subarray is sum_of_elements/no_of_elements.
In this no. of elements is same in each subarray as we have to find only subarray of size k.
So now question reduces to find subarray which has miniumm sum.
 
 */
public class Sub_FindMinAvgSubarray {

	public static void main(String[] args) {

		int A[] = { 15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18 };
		int B = 6;
		System.out.println(findMinAvgSubarray(A, B));
	}

	public static int findMinAvgSubarray(int A[], int k) {
		int n = A.length;
		int res_index = 0;

		int cur_sum = 0;
		for (int i = 0; i < k; i++)
			cur_sum += A[i];

		int min_sum = cur_sum;

		for (int i = k; i < n; i++) {
			cur_sum += A[i] - A[i - k];

			if (cur_sum < min_sum) {
				min_sum = cur_sum;
				res_index = i - k + 1;
			}
		}
		return res_index;
	}
}
