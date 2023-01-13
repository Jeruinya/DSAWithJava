package com.scaler.dsa.arrays;

/**
You are given a string S, and you have to find all the amazing substrings of S.
An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input
Only argument given is string S.
Output
Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.

Input    ABEC
Output   6
Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 **/
import java.util.ArrayList;

public class Sub_PrintAllTheAmazingSubarrays {

	public static void main(String[] args) {
		String str = "ABEC";
		int count = printSubstringNaive(str);
		System.out.println(count);

		int count1 = printSubstringEfficient(str);
		System.out.println(count1);

		int count2 = printSubstringEfficient1(str);
		System.out.println(count2);
	}

	private static int printSubstringEfficient1(String str) {
		int n = str.length();
		int res = 0;
		String vowel = "aeiouAEIOU";
		for (int i = 0; i < n; i++) {
			if (vowel.contains(String.valueOf(str.charAt(i))))
				res = res + n - i;
		}
		return res % 10003;
	}

	private static int printSubstringEfficient(String A) {
		ArrayList<Character> se = new ArrayList<>();
		se.add('a');
		se.add('e');
		se.add('i');
		se.add('o');
		se.add('u');
		se.add('A');
		se.add('E');
		se.add('I');
		se.add('O');
		se.add('U');

		int n = A.length();
		long ans = 0;
		for (int i = 0; i < n; i++)
			if (se.contains(A.charAt(i)))
				ans += (n - i);
		
		return (int) (ans % 10003);
	}

	private static int printSubstringNaive(String str) {
		String substr = null;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				substr = str.substring(i, j);
				char c = substr.charAt(0);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
						|| c == 'O' || c == 'U') {
					count++;
				}

			}
		}
		return count % 10003;
	}
}
