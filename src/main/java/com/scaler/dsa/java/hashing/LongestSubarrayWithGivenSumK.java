package com.scaler.dsa.java.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarrayWithGivenSumK {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };
		int K = 5;

		int arr[] = longestSubarrayWithSumK(A, K);
		System.out.println(Arrays.toString(arr));

	}

	private static int[] longestSubarrayWithSumK(int[] A, int K) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		int s = 0, e = -1;
		int maxLen = 0;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
			if (sum - K == 0) {
				int len = i + 1;
				if (maxLen < len) {
					maxLen=len;
					s = 0;
					e = i;
				}
			}
			if (hm.containsKey(sum - K)) {
				int len = i - hm.get(sum - K);
				if (maxLen < len) {
					maxLen=len;
					s = hm.get(sum - K)+1;
					e = i;
				}
			} else
				hm.put(sum, i);
		}
		int arr[]=new int[0];
		if(e!=-1) {
			arr=new int[e-s+1];
			int c=0;
			for(int i=s;i<=arr.length;i++)
				arr[c++]=A[i];
		}
		return arr;
	}

}
