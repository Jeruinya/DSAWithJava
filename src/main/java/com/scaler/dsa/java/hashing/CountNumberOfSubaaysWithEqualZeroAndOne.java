package com.scaler.dsa.java.hashing;

import java.util.HashMap;
import java.util.Map;

/*
Given an array A[] of size n containing 0 and 1 only. The problem is to count the subarrays having 
an equal number of 0’s and 1’s.

Examples:  
Input: arr[] = {1, 0, 0, 1, 0, 1, 1}
Output: 8
Explanation: 
The index range for the 8 sub-arrays are: (0, 1), (2, 3), (0, 3), (3, 4), (4, 5)(2, 5), (0, 5), (1, 6)

Input: arr = { 1, 0, 0, 1, 1, 0, 0, 1}
Output: 12


Follow the steps below for implementation:
Create a map say mp.
Iterate over the length of the given array
Check if arr[i] == 0, then replace it with -1.
Keep calculating the number into sum till ith index.
If sum = 0, it implies the number of 0’s and 1’s are equal from arr[0]..arr[i]
if mp[sum] exists then add “frequency-1” to count
if the frequency of “sum” is zero then we initialize that frequency to 1, if it’s not 0, we increment it
Finally, return the coun
 */
public class CountNumberOfSubaaysWithEqualZeroAndOne {

	public static void main(String[] args) {
		int A[] = { 1, 0, 0, 1, 0, 1, 1 };
		System.out.println(countSubarrWithEqualZeroAndOne(A));
	}

	static int countSubarrWithEqualZeroAndOne(int[] A) {
		Map<Integer, Integer> hm = new HashMap<>();
		int n = A.length;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == 0)
				A[i] = -1;

			sum += A[i];

//If sum = 0, it implies number of 0's and 1's are equal from arr[0]..arr[i]
			if (sum == 0)
				count++;

			if (hm.containsKey(sum))
				count += hm.get(sum);

			if (hm.containsKey(sum))
				hm.put(sum, hm.get(sum) + 1);
			else
				hm.put(sum, 1);
		}
		return count;
	}
}
