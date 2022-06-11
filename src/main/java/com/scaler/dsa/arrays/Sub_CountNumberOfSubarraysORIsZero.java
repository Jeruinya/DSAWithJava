package com.scaler.dsa.arrays;

/*
Given a binary array , calculate number of subarrays whose OR is zero.
A[]=[1,0,1,0,0]
subarrays---> [1]-1  	[1,0] [1,0,1] [1,0,1,0] [1,0,1,0,0]
			  [0]-0 	[0,1] [0,1,0] [0,1,0,0]
			  [1]-1		[1,0] [1,0,0]
			  [0]-0 	[0,0]
			  [0]-0

In every subarray we only needs to have zeros in all the subarrays to get zero as resultant OR.
 */
public class Sub_CountNumberOfSubarraysORIsZero {

	public static void main(String[] args) {
		int A[] = { 1, 0, 1, 0, 0 };
		int count = countNumberOfSubarraysWithORZero(A);
		System.out.println(count);
	}

	private static int countNumberOfSubarraysWithORZero(int[] A) {
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
		return ans;

	}
}
