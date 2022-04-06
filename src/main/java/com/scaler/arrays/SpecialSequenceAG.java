package com.scaler.arrays;

/**
 * Special Subsequences "AG" Problem Description You have given a string A
 * having Uppercase English letters. You have to find how many times subsequence
 * "AG" is there in the given string. NOTE: Return the answer modulo 109 + 7 as
 * the answer can be very large.
 */

public class SpecialSequenceAG {

	public static void main(String[] args) {
		String A = "ABCGAG";
		int count = SpecialSequenceNaive(A);
		System.out.println(count);

		int count1 = SpecialSequenceEfficient(A);
		System.out.println(count1);

	}

	private static int SpecialSequenceNaive(String a) {
		int count=0;
		for(int i=0;i<a.length();i++) {
			for(int j=i+1;j<a.length();j++)
				if(a.charAt(i)=='A' && a.charAt(j)=='G')
					count++;
		}
		return count;
	}

	public static int SpecialSequenceEfficient(String A) {
		int ans = 0;
		int count_a = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'A')
				count_a++;
			else if (A.charAt(i) == 'G')
				ans = count_a + ans;
		}
		return ans;
	}
}
