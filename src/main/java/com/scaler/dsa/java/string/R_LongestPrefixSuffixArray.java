package com.scaler.dsa.java.string;

import java.util.Arrays;

/*
Given a string S of size N, return the LPS array. LPS[i]=LPS value of substring[0....i].
LPS[i]= LPS of prefix string ending at i.

Example:
S=	"a a b a a b a"
   	 0 1 2 3 4 5 6
LPS	 


LPS[0] 					LPS[0] simply means if your string ends at 0 then what will be the prefix and suffix string will be.
	"a"
	
  prefix		suffix
  	a				a			but we can not take the complete string so LPS is 0
LPS[0]=0

LPS[1]   "aa"
			
	prefix		suffix
	  a				a
	  aa			aa  we can take complete string 
	  
LPS[1]=1;

LPS[2]: "aab"  0
LPS[3]: "aaba"  1
LPS[4]:	"aabaa"  2
LPS[5]: "aabaab"  3
LPS[6]: "aabaaba"  4

LPS[]={0,1,0,1,2,3,4}

Time Complexity:
LPS[i]: Generating all the prefix and suffix strings and comparing: O(N^2)
LPS[i] for every i: =O(N^3).

But there exists an algorithm which can do this work in O(N) time.

Why LPS array is important? and how it could help in pattern matching?

Text= "aabacd"  length n=6
pat= "abac"     length m=4
Join pat+Text  ="a b a c a a b a c d"
lps[10]=		 0 0 1 0 1 1 2 3 4 0

Observation: if lps[i]==m that means pattern is present in the text and it can be present at multiple places.


KMP Algorithm(1970-1977)
Calculate LPS array:

Step 1:
Sn= s0 s1 s2 s3 s4 s5 ...............si-5 si-4 si-3 si-2 si-2 si-1 si ......sn-1

Assume value till LPS[i-1] is already calculated.
LPS[i]=5 means first 5 letters matched with 5 letters ending at i.

S0 S1 S2 S3 S4= Si-4 Si-3 Si-2 Si-1 Si

		0 1 2 3 4 5 6  indexes
S = 	a a c b a a c
LPS		0 1 0 0 1 2 3

				0 1 2   4 5 6
LPS[6]= 3 means a a c = a a c

Claim: LPS[i] exceeds LPS[i-1] by at most 1.

S=		c a c y c a c y z
LPS=	0 0 1 0 1 2 3 2 0  increment in LPS can never be greater than one but it can decrease to any number till zero.
			
			LPS[i]=x   , x could x+1  if increase or it can be x-1, x-2 ......0

Claim: LPS[i]= LS[i-1]+1

Step 2:
   	0 1 2 3 4 5 6 7
S= 	a b a y a b a y	
LPS 0 0 1 0 1 2 3 ? 

x= LPS[i-1]
if(S[x]==S[i] then LPS[i]=LPS[i-1]+1

Step 3:
      0	 1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23
S= 	  a  b  c  a  b  d  a  b  c  a  b  e  a  b  c  a  b  d  a  b  c  a  b  c 
LPS   0   0 0  1  2  0  1  2  3  4  5  0  1  2  3  4  5  6  7  8  9  10 11 ?       what will be the LPS of i.

x=LPS[i-1] =11

	  x. S[x]==S[i] .
	..............................
   11  .	e==c	.no  x=LPS[x-1]
   5   .     d==c   .no x=LPS[x-1]
   2   .     c==c   . yes LPS[i]=x+1
	   .            .

Case No match:

S=	 a b a d a b a e
LPS  0 0 1 0 1 2 3 ?

x= LPS[i-1]

x		S[x]==S[i]	
3       d==e    no x= LPS[x-1]
1		b==e    no x= LPS[x-1]
0   	a==e	no x=LSP[x-1]= LPS[-1]   Special case if(x==0 && no match) break.


 
 */
public class R_LongestPrefixSuffixArray {

	public static void main(String args[]) {
		String txt = "abacabad";
		System.out.println(Arrays.toString(fillLPSNaive(txt)));
		System.out.println(Arrays.toString(fillLPSEfficient(txt)));
		System.out.println(Arrays.toString(fillLPSEff(txt)));

	}

	// Time Complexity O(N^3)
	static int[] fillLPSNaive(String A) {
		int lps[] = new int[A.length()];
		for (int i = 0; i < A.length(); i++) {
			lps[i] = longPropPreSuffNaive(A, i + 1);
		}
		return lps;
	}

	static int longPropPreSuffNaive(String str, int n) {
		for (int len = n - 1; len > 0; len--) {
			boolean flag = true;
			for (int i = 0; i < len; i++)
				if (str.charAt(i) != str.charAt(n - len + i))
					flag = false;

			if (flag == true)
				return len;
		}
		return 0;
	}

	static int[] fillLPSEff(String S) {
		int n = S.length();
		int lps[] = new int[n];
		//lps[0] = 0;
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
		return lps;
	}

	static int[] fillLPSEfficient(String str) {

		int n = str.length(), len = 0;
		int lps[] = new int[n];
		lps[0] = 0;
		int i = 1;
		while (i < n) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len == 0) {
					lps[i] = 0;
					i++;
				} else {
					len = lps[len - 1];
				}
			}
		}
		return lps;
	}
}