package com.scaler.dsa.java.string;

public class StringIsSubsequenceOfOther {

	static boolean isSubSeq(String s1, String s2, int n, int m) {
		int j = 0;
		for (int i = 0; i < n && j < m; i++) {
			if (s1.charAt(i) == s2.charAt(j))
				j++;
		}
		return j == m;
	}

	static boolean isSubSeqReccursive(String s1, String s2, int n, int m) {
		if (m == 0)
			return true;

		if (n == 0)
			return false;

		if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return isSubSeqReccursive(s1, s2, n - 1, m - 1);

		else
			return isSubSeqReccursive(s1, s2, n - 1, m);
	}

	public static void main(String[] args) {
		int n, m;
		String s1 = "abcdef";
		String s2 = "ade";
		n = s1.length();
		m = s2.length();

		System.out.println(isSubSeq(s1, s2, n, m));
		System.out.println(isSubSeqReccursive(s1, s2, n, m));

	}

}
