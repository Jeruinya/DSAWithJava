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
public class CyclicPermutations {

	public static void main(String[] args) {
		String A = "1001";
		String B = "0011";
		System.out.println(countAllCyclicPer(A, B));

	}

	public static int countAllCyclicPer(String A, String B) {
		String str = A + A; // add both the string so that cyclic count can we check
		int ans = 0;
		for (int i = 1; i < str.length(); i++) {
			if (B.length() + i > str.length()) { // edge case next window should be in range
				continue;
			}
			String str1 = str.substring(i, B.length() + i); // check substring of window same to string
			if (B.equals(str1)) {
				ans += 1;
			}
		}
		return ans;
	}

	public static int solve(String A, String B) {
		// append B to B to tackle cyclic permutations
		B += B;
		int n = A.length(), m = B.length();
		int lps[] = new int[n];
		computeLPS(lps, A);
		int i = 0, l = 0, ans = 0;
		while (i < m - 1) {
			if (B.charAt(i) == A.charAt(l)) {
				i++;
				l++;
			}
			if (l == n) {
				l = lps[l - 1];
				ans++;
			} else if (i < m && B.charAt(i) != A.charAt(l)) {
				if (l > 0) {
					l = lps[l - 1];
				} else {
					i++;
				}
			}
		}
		return ans;
	}

	// function used to longest proper suffix array
	public static void computeLPS(int lps[], String s) {
		int n = s.length();
		lps[0] = 0;
		int l = 0, i = 1;
		while (i < n) {
			if (s.charAt(i) == s.charAt(l)) {
				lps[i] = l + 1;
				i++;
				l++;
			} else {
				if (l > 0) {
					l = lps[l - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}
}
