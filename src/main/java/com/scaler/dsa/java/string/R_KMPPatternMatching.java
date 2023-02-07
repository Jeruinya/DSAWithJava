package com.scaler.dsa.java.string;

/*
Given a huge text and a pattern, check whether the given pattern matches in the text or not. 
If matched then return the starting index in the text where pattern matches.

Note:Pattern could a word or a substring.

Algorithm to check whether a pattern is present in the text are not and if present then count at how many places its present.
1: concatenate pattern and text  tat is String S= Pat+Text
2: Construct LPS array
3: Iterate over LPS array and check if LPS[i]==M thn do count++.
4: Return the count.

Observation: if LPS[i]==m that means pattern is present in the text and it can be present at multiple places.

Why Concatenation is required? 
concatenation makes the pattern as prefix in the text

Example: 
Text: "dabccabcf"  length n= 9
Pat :"abc"  length m=3
Text+Pat= "a b c d a b c c a b c f"
LPS[]=	   0 0 0 0 1 2 3 0 1 2 3 0

effective length of LPS array is N+M

Example: 
		Text="aaaa"
		Pat= "aa"
Algorithm:

S=Text+Pat=	"a a a a a a"
LPS[]=		 0 1 2 3 4 5
Now count all the indices where LPS>=2.
count=4-1=3

In the above we can see occurrences of pat is at 3 places bit our algorithm is giving result as 4.
Fix the above issue:

Pat+Text: add some special character between pat and text which is not given in the input and this issue will be resolved.

Pat+Text= "a a $ a a a a"
LPS[]=	   0 1 0 1 2 2 2

If we want to count at how many places the pattern present in the text, we have to just iterate over LPS array and check
if(lps[i]==pat.length)
	count++
 return count
 
 */
public class R_KMPPatternMatching {
	public static void main(String args[]) {
		String txt = "dabccabcf", pat = "abc";
		System.out.println("Pattern Present At Index:" + solve(txt, pat));
		System.out.println("Pattern Present At Index:" + patSearchinng(txt, pat));
	}

	// TC-O(N+M) Space-O(N+M) 
	private static int solve(String txt, String pat) {
		String finalString = pat + "$" + txt;
		int m = pat.length();
		int j = pat.length() + 1;// length of pat+$
		int n = finalString.length();
		int lps[] = new int[n];
		fillLPS(finalString, lps);
		for (int i = 0; i < lps.length; i++) {
			if (lps[i] == pat.length())
				return i - m + 1 - j;
		}
		return -1;
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

	// Time Complexity -O(N*M) , Space-O(1)
	static int patSearchinng(String txt, String pat) {
		int m = pat.length();
		int n = txt.length();
		for (int i = 0; i <= (n - m); i++) {
			int j;
			for (j = 0; j < m; j++)
				if (pat.charAt(j) != txt.charAt(i + j))
					break;

			if (j == m)
				return i;
		}
		return -1;
	}

}