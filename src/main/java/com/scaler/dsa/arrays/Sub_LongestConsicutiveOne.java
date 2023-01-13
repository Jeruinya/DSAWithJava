package com.scaler.dsa.arrays;

/*
  Given a binary string A. It is allowed to do at most one swap between any 0 and 1. 
  Find and return the length of the longest consecutive 1’s that can be achieved.

Input Format
The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
Input 1:
 A = "111000"
Output 1:  3

Input 2:
    A = "111011101"
Output 2:   7
 */

public class Sub_LongestConsicutiveOne {

	public static void main(String[] args) {
		String A = "111011101";
		System.out.println(longestConsecutiveOne(A));
	}

	private static int longestConsecutiveOne(String A) {
		int ans = 0, count = 0;
		int n = A.length();
		for (int i = 0; i < n; i++) {

			if (A.charAt(i) == '0') {
				int l = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (A.charAt(j) == '1')
						l++;
					else
						break;
				}

				int r = 0;
				for (int k = i + 1; k < n; k++) {
					if (A.charAt(k) == '1')
						r++;
					else
						break;
				}

				ans = Math.max(ans, l + r + 1);
			}

			else
				count++;

		}

		if (count == n)
			return count;
		else
			return Math.min(count, ans);

	}
}