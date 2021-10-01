package com.dsa.java.string;

public class LongestPrefixSuffixArray {

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

	static void fillLPS(String str, int lps[]) {
		for (int i = 0; i < str.length(); i++) {
			lps[i] = longPropPreSuffNaive(str, i + 1);
		}
	}

	static void fillLPSEfficient(String str, int lps[]) {
		int n = str.length(), len = 0;
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
	}

	public static void main(String args[]) {
		String txt = "abacabad";
		int[] lps = new int[txt.length()];
		fillLPS(txt, lps);
		for (int i = 0; i < txt.length(); i++) 
			System.out.print(lps[i] + " ");
			
		System.out.println();
			//For efficient solution
			String txt1 = "abacabad";
			int[] lps1 = new int[txt1.length()];
			fillLPSEfficient(txt1,lps1);
			for (int i1 = 0; i1 < txt1.length(); i1++) 
				System.out.print(lps[i1] + " ");
			
	}
}