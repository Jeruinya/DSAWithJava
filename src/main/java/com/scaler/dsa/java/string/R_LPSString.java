package com.scaler.dsa.java.string;

/*
Given a string s, find the length of the longest prefix, which is also a suffix. The prefix and suffix should not overlap.

Prefix String: Substring starting with Oth index.
String A="abab"
	a
	ab
	aba
	abab

Suffix string: Any substring that starts with any idex but ending at n-1 th index.
String A="abab"
	b
	ab
	bab
	abab

LPS-->Length of longest prefix which is also suffix string except the entire string.
String A="abcab"

	Prefix			Suffix
	a				b
	ab				ab
	abc				cab
	abca			bcab
	abcab			abcab   This prefix suffix is not allowed because its having entire string
So length of the logest prefix suffix string is ab -2

String A="a"  len=0

String A="aaaaa"

	prefix		suffix
	 a			a
	 aa			aa
	 aaa		aaa
	 aaaa		aaaa
	 aaaaa		aaaaa not allowed so the length of longest prefix suffix is 4.

String A= s0 s1 s2 s3 s4 s5

	prefix				suffix
	s0					s5		
	s0 s1				s4 s5
	s0 s1 s2 			s3 s4 s5
	s0 s1 s2 s3		    s2 s3 s4 s5
	s0 s1 s2 s3 s4 		s1 s2 s3 s4 s5

Time complexity to find LPS: 

1+2+3+4+................n-1   (n-1)*n/2= O(N^2)



 */
public class R_LPSString {

	public static void main(String[] args) {
		String s = "abcab";
		System.out.println(longestPrefixSuffix(s));

	}

	static int longestPrefixSuffix(String s) {
		int n = s.length();
		int lps[] = new int[n];

		lps[0] = 0;
		int len = 0;

		int i = 1;
		while (i < n) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				}

				else {
					lps[i] = 0;
					i++;
				}
			}
		}

		int res = lps[n - 1];

		return (res > n / 2) ? n / 2 : res;
	}
}
