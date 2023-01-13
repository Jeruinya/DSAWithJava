package com.scaler.dsa.arrays;

/*
Problem Description
You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.

Problem Constraints
1 <= length(A) <= 105

Input Format
First and only argument is a string A.

Output Format
Return an integer denoting the answer.

Input 1: A = "ABCGAG"
Input 2: A = "GAB"

Output 1: 3
Output 2: 0

Explanation 1:
 Subsequence "AG" is 3 times in given string 

Explanation 2:
 There is no subsequence "AG" in the given string.
 */
public class SpecialSequenceAG {

	public static void main(String[] args) {
		String A = "ABCGAG";
		System.out.println(SpecialSequenceNaive(A));

		System.out.println(SpecialSequenceEfficient(A));

	}

	private static int SpecialSequenceNaive(String a) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = i + 1; j < a.length(); j++)
				if (a.charAt(i) == 'A' && a.charAt(j) == 'G')
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
