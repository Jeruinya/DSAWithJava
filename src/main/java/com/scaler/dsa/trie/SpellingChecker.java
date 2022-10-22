package com.scaler.dsa.trie;

import java.util.ArrayList;
import java.util.HashMap;

import com.scaler.dsa.trie.ShortestUniquePrefix.TrieNode;

/*
Problem Description
Given an array of words A (dictionary) and another array B (which contain some words).
You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is 
present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
Such problems can be seen in real life when we work on any online editor (like Google Documnet), 
if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.
Problem Constraints
1 <= |A| <= 1000
1 <= sum of all strings in A <= 50000
1 <= |B| <= 1000

Input Format
First argument is array of strings A.
First argument is array of strings B.

Output Format
Return the binary array of integers according to the given format.

Input 1:
A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:
A = [ "tape", "bcci" ]
B = [ "table", "cci" ]

Output 1:[1, 0]
Output 2:[0, 0]

Explanation 1:
Only "cat" is present in the dictionary.

Explanation 2:
None of the words are present in the dictionary.

Approach:
1- just use two loops and check if word from B is present in the dictionary or not and if present just as 1 in result
   list else add 0.
   Time complexity-Size(A)* size(B)==> O(N*M)  space -O(1)
   
2- Use Trie to optimize the time.
   * Build Trie to store the dictionary. Time complexity of creating the Trie for Dictionary A is M*K where M is the size
   of the dictionary and K is the maximum length string/word present in the dictionary.
   
   *Searching: For every word in B we are just going to search in Trie.
   *Time complexity of searching the elements of B in dictionary A is N*K.

So overall time complexity will be O(M*K+N*K) here K will not be that much big string so can assume it as constant
then TC-O(M+N)

Space complexity-O(M)

Here M is the size of list A and N is the size of list B.

Use below input to understand the use of count:
A : [ "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg" ]
B : [ "a", "b", "ab", "abcd" ]
   
 */
public class SpellingChecker {

	static class TrieNode {
		char data;
		int count;
		HashMap<Character, TrieNode> hm;

		TrieNode(char d) {
			data = d;
			count = 0;
			hm = new HashMap<>();
		}
	}

	static TrieNode root;

	public static void main(String[] args) {
		ArrayList<String> A = new ArrayList<>();
		A.add("hat");
		A.add("cat");
		A.add("rat");
		ArrayList<String> B = new ArrayList<>();
		B.add("cat");
		B.add("ball");

		System.out.println(spellingChecker(A, B));

		System.out.println(spellingCheckerEff(A, B));

	}

	public static ArrayList<Integer> spellingCheckerEff(ArrayList<String> A, ArrayList<String> B) {
		root = new TrieNode('\0');
		ArrayList<Integer> res = new ArrayList<>();

		for (String word : A)
			insert(word);

		for (int i = 0; i < B.size(); i++)
			if (search(root, B.get(i)))
				res.add(1);
			else
				res.add(0);

		return res;
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
		temp.count++;
	}

	private static boolean search(TrieNode root, String word) {
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			if (!temp.hm.containsKey(word.charAt(i)))
				return false;
			else
				temp = temp.hm.get(word.charAt(i));
		}

		if (temp.count > 0) {
			temp.count--;
			return true;
		}

		return false;
	}

	// Time complexity-Size(A)* size(B)==> O(N*M) space -O(1)
	public static ArrayList<Integer> spellingChecker(ArrayList<String> A, ArrayList<String> B) {
		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < B.size(); i++) {
			boolean flag = true;
			for (int j = 0; j < A.size(); j++) {
				if (B.get(i).equals(A.get(j))) {
					res.add(1);
					flag = false;
					break;
				}
			}
			if (flag == true)
				res.add(0);
		}
		return res;
	}
}
