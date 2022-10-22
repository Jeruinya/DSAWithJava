package com.scaler.dsa.trie;

import java.util.HashSet;

/*
Problem Description

Given two arrays of strings A of size N and B of size M.

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification 
in B[i], Else C[i] = '0'.
NOTE: modification is defined as converting a character into another character.

Problem Constraints
1 <= N <= 30000
1 <= M <= 2500
1 <= length of any string either in A or B <= 20

strings contains only lowercase alphabets
Input Format
First argument is the string arrray A.
Second argument is the string array B.

Output Format
Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using one modification 
in B[i], Else C[i] = '0'.

Input 1:
 A = [data, circle, cricket]
 B = [date, circel, crikket, data, circl]
Input 2:
 A = [hello, world]
 B = [hella, pello, pella]


Output 1: "10100"
Output 2: "110"


Explanation 1:
 1. date = dat*(can be found in A)
 2. circel =(cannot be found in A using exactly one modification)
 3. crikket = cri*ket(can be found in A)
 4. data = (cannot be found in A using exactly one modification)
 5. circl = (cannot be found in A using exactly one modification)

Explanation 2:
 Only pella cannot be found in A using only one modification.
 */
public class ModifiedSearch {

	private static class TrieNode {

		private char data;
		private boolean isEnd;
		private TrieNode[] children;

		public TrieNode(char data) {
			this.data = data;
			this.isEnd = false;
			this.children = new TrieNode[26];
		}
	}
	static TrieNode root;

	public static void main(String[] args) {
		String A[] = { "data", "circle", "cricket" };
		String B[] = { "date", "circel", "crikket", "data", "circl" };
		root = new TrieNode('/');
		System.out.println(modifiedSearchEff(A, B));
	}

	public static String modifiedSearchEff(String[] A, String[] B) {

		for (String word : A)
			insertWord(word);

		StringBuilder ans = new StringBuilder();

		HashSet<String> set = new HashSet<>();

		for (String word : B) {
			set.add(word);
			boolean isFound = false;
			char[] charArr = word.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				char oldChar = charArr[i];
				for (char ch = 'a'; ch <= 'z'; ch++) {

					charArr[i] = ch;
					String newString = new String(charArr);
					if (set.contains(newString)) {
						continue;
					}
					isFound = searchWord(newString);
					if (isFound) {
						break;
					}
				}
				charArr[i] = oldChar;
				if (isFound) {
					break;
				}
			}
			if (isFound) {
				ans.append(1);
			} else {
				ans.append(0);
			}
		}
		return new String(ans);
	}

	private static void insertWord(String word) {

		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			int childIdx = word.charAt(i) - 'a';
			if (temp.children[childIdx] == null) {
				temp.children[childIdx] = new TrieNode(word.charAt(i));
			}
			temp = temp.children[childIdx];
		}
		temp.isEnd = true;

	}

	private static boolean searchWord(String word) {

		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			int childIdx = word.charAt(i) - 'a';
			if (temp.children[childIdx] == null) {
				return false;
			}
			temp = temp.children[childIdx];
		}
		return temp.isEnd;
	}
}
