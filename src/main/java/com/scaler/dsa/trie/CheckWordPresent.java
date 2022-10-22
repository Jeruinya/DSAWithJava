package com.scaler.dsa.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Tries: Tries can have n number of nodes associated to root.
Prefix tree
information retrieval
N-ary tree

Given a list of words and we have Q queries, check whether that word is present in the list or not.

Approach:
1-Linear search for every query.  Time complexity- O(N*M*Q)
2-Sort list and do binary search  Time Complexity-O(m*nLogn)
3-Put all the words into hashSet in O(n).
	Now for every query look for the word in HashSet which is in O(1)
	So time complexity will be -O(N*M+Q*M) is we ignore M then it will be O(N+Q)
	
4: we can use tries:
Node Structure :
-char data
-boolean isTerminal
-Array or HashMap or HashSet

for English Alphabets the array size will be 26.


 */
public class CheckWordPresent {
	static TrieNode root;

	public static void main(String[] args) {
		List<String> list = Arrays.asList("cat", "bat", "tab", "batman", "apple", "ape", "news");
		root = new TrieNode('\0');

		for (String word : list)
			insert(word);
		System.out.println(search("batman"));

	}

	private static void insert(String word) {
		TrieNode temp = root;
		for (char s : word.toCharArray()) {
			if (!temp.hm.containsKey(s)) {
				TrieNode n = new TrieNode(s);
				temp.hm.put(s, n);
			}
			temp = temp.hm.get(s);
		}
		temp.isTerminal = true;

	}

	private static boolean search(String queryWord) {
		TrieNode temp = root;
		for (char c : queryWord.toCharArray()) {
			if (temp.hm.containsKey(c))
				temp = temp.hm.get(c);
			else
				return false;
		}
		return temp.isTerminal;
	}

}
