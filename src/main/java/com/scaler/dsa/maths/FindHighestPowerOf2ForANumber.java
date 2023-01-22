package com.scaler.dsa.maths;

/*
So here a number is given and we have to find a number which is power of 2 and nearest to n.

An efficient solution is to use bitwise left shift operator to find all powers of 2 starting from 1. 
For every power check if it is smaller than or equal to n or not.
 */
public class FindHighestPowerOf2ForANumber {

	public static void main(String[] args) {

		int n = 65;
		System.out.println(findHighestPowerOf2(n));
		System.out.println(findHighestPowerOf2EfficientSol(n));

	}

	private static int findHighestPowerOf2EfficientSol(int n) {
		int res = 1;
		if (n < 1)
			return 0;
		for (int i = 0; i <= n; i++) {
			int curr = 1 << i;
			if (curr > n)
				break;
			res = curr;
		}

		return res;
	}

	// O(N)
	private static int findHighestPowerOf2(int n) {
		int res = 0;
		for (int i = n; i >= 1; i--) {
			if ((i & (i - 1)) == 0) {
				res = i;
				break;
			}
		}
		return res;
	}

}
