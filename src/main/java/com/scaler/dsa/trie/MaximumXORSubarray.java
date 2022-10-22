package com.scaler.dsa.trie;

import java.util.Arrays;

/*
Problem Description
Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, 
which has maximum XOR value.
NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length. 
If the length is the same, return the subarray with the minimum starting index.

Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 109

Input Format
First and only argument is an integer array A.

Output Format
Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the 
ending index(1-based) of the subarray.

Input 1: A = [1, 4, 3]
Input 2: A = [8]

Output 1: [2, 3]
Output 2: [1, 1]

Explanation 1:
 There are 6 possible subarrays of A:
 subarray            XOR value
 [1]                     1
 [4]                     4
 [3]                     3
 [1, 4]                  5 (1^4)
 [4, 3]                  7 (4^3)
 [1, 4, 3]               6 (1^4^3)

 [4, 3] subarray has maximum XOR value. So, return [2, 3].

Explanation 2:
 There is only one element in the array. So, the maximum XOR value is equal to 8 and the 
 only possible subarray is [1, 1]. 
 
Approach:
To find the maximum subarray XOR we have to calculate prefix XOR.
	prefixXor(i)= prefixXor(i-1)^A[i]
	
A[]=[5,3,2,6]
PrefixXor[]=[5,6,4,2]




 */
public class MaximumXORSubarray {

	public static void main(String[] args) {
		int A[] = { 1, 4, 3 };
		int res[] = maximumXorSubarray(A);
		System.out.println(Arrays.toString(res));
		System.out.println(maximumXorSumSubarray(A));

	}

	public static int[] maximumXorSubarray(int[] A) {
		int ans = Integer.MIN_VALUE;
		int n = A.length;
		int s = 0;
		int e = -1;

		for (int i = 0; i < n; i++) {
			int curr_xor = 0;
			for (int j = i; j < n; j++) {
				curr_xor = curr_xor ^ A[j];
				if (curr_xor > ans) {
					ans = curr_xor;
					s = i;
					e = j;
				} else if (curr_xor == ans && j - i + 1 < e - s + 1) {
					ans = curr_xor;
					s = i;
					e = j;
				}
			}
		}
		return new int[] { s + 1, e + 1 };
	}

	private static int maximumXorSumSubarray(int[] A) {
		int n = A.length;
		int ans = 0;
		int prefixXor[] = new int[n];
		prefixXor[0] = A[0];

		for (int i = 1; i < n; i++)
			prefixXor[i] = prefixXor[i - 1] ^ A[i];

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int subarrauXor;
				if (i == 0) {
					subarrauXor = prefixXor[0];
				} else {
					subarrauXor = prefixXor[j] ^ prefixXor[i - 1];
				}
				ans = Math.max(ans, subarrauXor);
			}
		}
		return ans;
	}

}
