package com.scaler.dsa.java.string;

/*
Given a binary string S, find number of cyclic rotations which are same as original string.
S="abcd"
	r1=bcda
	r2=cdab
	r3=dabc
	r4=abcd

For a given string how many rotations are possible?
Ans: length of string

Here we have to find how many of them are same as the original string.

Example:
	S="1010"
	r1=0101
	r2=1010  Match as original string
	r3=0101
	r4=1010  Match as original string
So Answer is 2.

S="abcd"

S'=ss	="abcdabcd"

Here claim is that the combined text will have all the possible rotations.

Algorithm:
S=1010
Text=SS
pat	S
	
	Pat+Text= S $ SS    1010 $ 1010 1010
	 		Time Complexity= n+1+n+n= 3n+1
	 		=> O(N)

	
 */
public class R_CyclicRotations {

	public static void main(String[] args) {
		String S = "1010";
		System.out.println(countCyclicRotations(S));

	}

	private static int countCyclicRotations(String S) {
		String pat = S;
		int count = 0;
		String finalText = pat + "$" + S + S;

		int n = finalText.length();
		int m = pat.length();

		int lps[] = new int[n];
		fillLPS(finalText, lps);

		for (int i = 0; i < n; i++)
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
