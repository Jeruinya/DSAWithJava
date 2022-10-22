package com.scaler.dsa.trie;

import java.util.ArrayList;

/*
Problem Description
Given a list of N words, find the shortest unique prefix to represent each word in the list.
NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible

Problem Constraints
1 <= Sum of length of all words <= 106

Input Format
First and only argument is a string array of size N.

Output Format
Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

Input 1: A = ["zebra", "dog", "duck", "dove"]
Input 2: A = ["apple", "ball", "cat"]

Output 1: ["z", "dog", "du", "dov"]
Output 2: ["a", "b", "c"]

Explanation 1:
 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
 
Explanation 2:
 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 
Approach:Find the shortest unique prefix for each word means find the shortest prefix of each word which is not common 
		 into any string.
	
1-Brute Force: Try out every prefix of every word and iterate over the list of words to find the shortest unique prefix.

Optimized Approach:Use Trie

Time Complexity: O(N*L)+O(N*M)

O(N*L): For building the Trie
O(N*M): for searching 

Space complexity: O(N*L)

L-Average length of the string
M-Maximum length of the string




 */
public class ShortestUniquePrefix {

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isTerminal;
		int count;

		TrieNode() {
			isTerminal = false;
			count = 0;

		}
	}

	static TrieNode root;

	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<>();
		A.add("detective");
		A.add("common");
		A.add("defeat");
		A.add("cowards");
		
		root = new TrieNode();

		for (String word : A)
			insert(word);

		ArrayList<String> res = prefix(A);
		System.out.println(res);

	}

	static void insert(String key) {
		int index;

		TrieNode temp = root;

		for (int i = 0; i < key.length(); i++) {
			index = key.charAt(i) - 'a';

			if (temp.children[index] == null) {
				temp.children[index] = new TrieNode();
			}

			temp = temp.children[index];
			temp.count++;
		}

		temp.isTerminal = true;

	}

	public static ArrayList<String> prefix(ArrayList<String> A) {

		ArrayList<String> res = new ArrayList<>();
		root = new TrieNode();

		for (int i = 0; i < A.size(); i++)
			insert(A.get(i));

		for (int i = 0; i < A.size(); i++) {
			res.add(getPrefix(A.get(i)));
		}

		return res;
	}

	// Returns true if key presents in trie, else false
	static String getPrefix(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode temp = root;
		String ans = "";

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (temp.count == 1) {
				return ans;
			} else {
				ans = ans + key.charAt(level) + "";
				temp = temp.children[index];
			}

		}

		return (ans);
	}

	/*
	 * private static List<String> findShortestUniquePrefix(List<String> list) {
	 * 
	 * List<String> res = new ArrayList<String>(); int n = list.size(); for (int i =
	 * 0; i < n; i++) { int k = 0; StringBuffer sb = new StringBuffer(); char c =
	 * list.get(i).charAt(k); sb.append(c); for (int j = 0; j < n; j++) { if (j !=
	 * i) {
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * return null; }
	 */

}
