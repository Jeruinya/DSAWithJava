package com.scaler.dsa.recursion;

/*
Find the shortest string after dissolving consecutive strings(similar letters)

example:1

aabbcccbxad
dissolve c--aabbbxad
dissolve a-bbbxad
dissolve b-xad ans

example:2
aabbcccbxxad

dissolve-c--aabbbxxad
dissolve b--aaxxad
dissolve x--aaad
dissolve a--d Answer is d as its the shortest string which we can compress and generate.

example:3
aabbbcca
dissolve b--aacca
dissolve c--aaa
dissolve a--{}

example:3
kaaabbccbaxd
kaaabbbaxd
kaaaaxd
kxd
 */
public class R_CompressString {

	public static void main(String[] args) {
		String s = "kaaabbccbaxd";
		System.out.println(dissolve(s));
		System.out.println(disolveSimple(s));

	}

	// Simple program just to remove duplicate characters
	// we can do this with frequency map in O(n) time and O(n) space. Below
	// program's time complexity is O(n) O(1)
	private static String disolveSimple(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		if (n < 1)
			return sb.toString();
		if (n == 1)
			return s;

		int i = 1;
		int j = 1;
		if (s.charAt(i) != s.charAt(i - 1)) {
			sb = sb.append(s.charAt(i - 1));
			i++;
		}
		while (i < n) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				j++;
				i++;
			}
			if (j == 1) {
				sb = sb.append(s.charAt(i));
				i++;
			}

			else {
				j = 1;
				i++;
			}
		}
		return sb.toString();
	}

	public static String dissolve(String s) {
		// rec case
		String res = s;
		for (int i = 0; i < s.length();) {
			int j = i;
			while (j < s.length() && s.charAt(j) == s.charAt(i)) {
				j++;
			}
			// found a segment that can be compressed
			if (j - i > 1) {
				String s_ = s.substring(0, i) + s.substring(j);
				String output = dissolve(s_);
				if (output.length() < res.length()) {
					res = output;
				}
			}
			i = j;
		}
		return res;
	}
}
