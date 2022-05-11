package com.scaler.dsa.java.hashing;

import java.util.HashMap;

/*
Find length of longest subarray with sum zero.
A=   [3,3,4,-5,-2,2,1,-3,3,-1,-5,-4,-1]---- for this array the answer is 11
ps[]=[3,6,10,5,3,5,6,3,6,5,0,-4,-5]

longest len = index of last occurrence - index of first occurrence.
first occurrence of 3 is at 0 and last occurrence is at 7  ans len= 7-0 =7

if zero occurs at index i then length of the subarray will be i+1.
Use hashMap to store the first occurrence

 */
public class FindLengthOfLongestSubArrayWithSumZero {

	public static void main(String[] args) {
		int A[] = { 3, 3, 4, -5, -2, 2, 1, -3, 3, -1, -5, -4, -1 };
		HashMap<Integer, Integer> hm = new HashMap<>();
		int n = A.length;
		int ans = Integer.MIN_VALUE;
		int ps[] = new int[n];
		ps[0] = A[0];
		for(int i=1;i<n;i++)
			ps[i]=ps[i-1]+A[i];
		
		for (int i = 0; i < n; i++) {
			if (ps[i] == 0) {
				ans = Math.max(ans, i + 1);
			} else if (hm.containsKey(ps[i])) {
				int newLen = i - hm.get(ps[i]);
				ans = Math.max(ans, newLen);
			} else
				hm.put(ps[i], i);
		}
		System.out.println(ans);

	}

}
