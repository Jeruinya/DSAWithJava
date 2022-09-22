package com.scaler.dsa.java.string;

import java.util.Arrays;
import java.util.HashMap;

/*
Given two string s1 and s2, check whether s2 is permutation of s1 or not?
example:
s1="abcda"
s2="aadcb"


 */
public class IsTwoStringsArePermutation {

	public static void main(String[] args) {
		String s1 = "abcda";
		String s2 = "aadcb";

		System.out.println(isPermutation(s1, s2));
		System.out.println(isPermutationEff(s1, s2));

	}

	private static boolean isPermutationEff(String s1, String s2) {

		HashMap<Character, Integer> hm1 = new HashMap<>();
		HashMap<Character, Integer> hm2 = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
			hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i), 0) + 1);
		}
		
		for(char c:hm1.keySet()) {
			if(hm1.get(c)!=hm2.get(c))
				return false;
		}

		return true;
	}

	// TC-O(nlogn) Space -O(n)
	private static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; i++)
			if (c1[i] != c2[i])
				return false;

		return true;
	}

}
