package com.scaler.dsa.trie;

/*
Problem Description

Given a phone directory in the form of string array A containing N numeric strings.
If any phone number is prefix of another phone number then phone directory is invalid else it is valid.
You need to check whether the given phone directory is valid or not if it is valid then return 1 else return 0.

Problem Constraints
2 <= N <= 105
1 <= |A[i]| <= 50
A[i] consists only of numeric digits.

Input Format
First and only argument is an string array A.

Output Format
Return 1 if the given phone directory is valid else return 0.


Input 1: A = ["1234", "2342", "567"]
Input 2: A = ["00121", "001"]


Output 1: 1
Output 2: 0

Explanation 1:
 No number is prefix of any other number so phone directory is valid so we will return 1.

Explanation 2:
 "001" is prefix of "00121" so phone directory is invalid so we will return 0.
 */
public class ValidPhoneDirectory {

	static class TrieNode {
		TrieNode[] children;
		boolean isTerminal;

		public TrieNode() {
			children = new TrieNode[10];
			isTerminal = false;
		}
	}

	static TrieNode root;

	public static void main(String[] args) {
		String A[] = { "1234", "2342", "567" };
		System.out.println(isValidPhoneDictionary(A));

	}

	public static int isValidPhoneDictionary(String[] A) {
		root = new TrieNode();
		for (String s : A) {
			if (insert(s)) {
				return 0;
			}
		}
		return 1;
	}

	/*
	 * Insert String in Trie with maintaining a flag (isPrefix) if we are adding new
	 * trieNode then string (s) is not prefix.
	 */
	private static boolean insert(String s) {
		TrieNode temp = root;
		boolean isPrefix = true;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - '0';

			if (temp.children[c] == null) {
				isPrefix = false;
				temp.children[c] = new TrieNode();
			}
			temp = temp.children[c];
		}
		return isPrefix;
	}
}
