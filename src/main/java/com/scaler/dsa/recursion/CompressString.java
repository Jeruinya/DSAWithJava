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
public class CompressString {

	public static void main(String[] args) {
		String input = "kaaabbccbaxd"; 
		System.out.println(dissolve(input));

	}

	public static String dissolve(String s) {
		// rec case
		String bestOutput = s;
		for (int i = 0; i < s.length();) {
			int j = i;
			while (j < s.length() && s.charAt(j) == s.charAt(i)) {
				j++;
			}
			// found a segment that can can compressed
			if (j - i > 1) {
				String s_ = s.substring(0, i) + s.substring(j);
				String output = dissolve(s_);
				if (output.length() < bestOutput.length()) {
					bestOutput = output;
				}
			}
			i = j;
		}
		return bestOutput;
	}
}
