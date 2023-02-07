package com.scaler.dsa.java.string;

/*
Problem Description
Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.
NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form 
Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.

Problem Constraints
1 ≤ length(A) = length(B) ≤ 105

Input Format
The first argument is a string A.
The second argument is a string B.

Output Format
Return an integer denoting the required answer.

Input 1:
 A = "1001"
 B = "0011"

Input 2:
 A = "111"
 B = "111"

Output 1: 1
Output 2: 3

Explanation 1:
 4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".  
 There is only one cyclic shift of B i.e. "1001" which has 0 xor with A.

Explanation 2:
 All cyclic shifts of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */
public class R_CyclicPermutations {

	public static void main(String[] args) {
		String A = "1101111111";
		String B = "1101111111";
		System.out.println(solve(A, B));

	}

	public static int solve(String A, String B) {
	       
	      
		int count = 0;
		String finalText = A + "$" + B + B;

		int n = finalText.length();
		int m = A.length();

		int lps[] = new int[n];
		fillLPS(finalText, lps);

		for (int i = 0; i < n-1; i++)
			if (lps[i] == m)
				count++;

		return count;
	}

	static void fillLPS(String S, int[] lps) {
		int n = S.length();
		for (int i = 1; i < n; i++) {
			int x = lps[i - 1];
			while (S.charAt(x) != S.charAt(i)) {
				if (x == 0) {
					x = -1;
					break;
				}
				x = lps[x - 1];
			}
			lps[i] = x + 1;

		}
	}
}
