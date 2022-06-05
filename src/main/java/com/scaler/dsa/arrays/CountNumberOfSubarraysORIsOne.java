package com.scaler.dsa.arrays;

/*
Given a binary array , calculate number of subarrays whose OR is one.
A[]=[1,0,1,0,0]
subarrays---> [1]-1  	[1,0] [1,0,1] [1,0,1,0] [1,0,1,0,0]
			  [0]-0 	[0,1] [0,1,0] [0,1,0,0]
			  [1]-1		[1,0] [1,0,0]
			  [0]-0 	[0,0]
			  [0]-0

In every subarray we only needs to have zeros in all the subarrays to get zero as resultant OR.
once we find the total number of subarrays with zero OR , just subtract the total number of subarrays with zero from total number of subarrays.
 */
public class CountNumberOfSubarraysORIsOne {

	public static void main(String[] args) {
		int A[] = { 1, 0, 1, 0, 0 };
		int count = countNumberOfSubarraysWithOROne(A);
		System.out.println(count);
	}

	private static int countNumberOfSubarraysWithOROne(int[] A) {
		int n = A.length;
		int ans = 0, c = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == 0)
				c++;
			else {
				ans = ans + c * (c + 1) / 2;
				c = 0;
			}
		}
		ans = ans + c * (c + 1) / 2;
		int totalSubarrays=n*(n+1)/2;
		return totalSubarrays-ans;

	}
}
