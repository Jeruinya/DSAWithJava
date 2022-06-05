package com.scaler.dsa.java.hashing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description
Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.
Input Format
First argument is an string A.
Output Format
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Input 1: A = "abcde"
Input 2: A = "abbaee"
Output 1: 0
Output 2: 1

Explanation 1:
 No possible rearrangement to make the string palindrome.
Explanation 2:
 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 
 Observations--------->
Context here is any string can be palindrome if:
1. Length of string is EVEN, then occurrence of every character should be even ONLY
2. Length of string is ODD, then occurrence of every character should be even and only one character have frequency should be odd.

Here I took the hashMap<Character , Integer> and store frequency of each character in  hashmap. 
Now if length is even then check every character’s frequency should be even
If length is odd only 1 character’s frequency should be odd.
 */
public class CheckAStringCanBeAPalindrome {

	public static void main(String[] args) {
		String str = "inttnikjmjbemrberk";
		int res = checkPalindrome(str);
		System.out.println(res);
	}

	private static int checkPalindrome(String A) {
		Map<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.length(); i++) {
			if (hm.containsKey(A.charAt(i)))
				hm.put(A.charAt(i), hm.get(A.charAt(i)) + 1);
			else
				hm.put(A.charAt(i), 1);
		}
		int temp = 0;
		for (Integer i : hm.values()) {
			if (i % 2 == 1)
				temp++;
			if (temp > 1)
				return 0;
		}
		return 1;
	}

}
