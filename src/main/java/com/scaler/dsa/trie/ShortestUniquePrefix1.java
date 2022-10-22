package com.scaler.dsa.trie;

import java.util.ArrayList;

public class ShortestUniquePrefix1 {

	static class TrieNode {
		char c;
		int val;
		TrieNode left, mid, right;

		public TrieNode() {
		}

		public TrieNode(char c) {
			this.c = c;
			this.val = 0;
		}
	}

	static private TrieNode root;

	public static void main(String[] args) {
		root = new TrieNode('\0');
		ArrayList<String> A = new ArrayList<>();
		A.add("detective");
		A.add("common");
		A.add("defeat");
		A.add("cowards");
		ArrayList<String> res = prefix(A);
		System.out.println(res);

	}

	public static ArrayList<String> prefix(ArrayList<String> A) {
		ArrayList<String> res = new ArrayList<>();
		for (String str : A) {
			put(str);
		}
		for (String str : A) {
			String prefix = getPrefix(str);
			res.add(prefix);
		}
		return res;
	}

	public static String getPrefix(String str) {
		StringBuilder strB = new StringBuilder();
		return get(root, str, 0, strB);
	}

	public static String get(TrieNode node, String str, int index, StringBuilder strB) {
		char c = str.charAt(index);
		if (c < node.c) {
			return get(node.left, str, index, strB);
		} else if (c > node.c) {
			return get(node.right, str, index, strB);
		} else if (node.val == 1) {
			strB.append(node.c);
			return strB.toString();
		} else {
			strB.append(node.c);
			return get(node.mid, str, index + 1, strB);
		}
	}

	public static void put(String str) {
		root = put(root, str, 0);
	}

	public static TrieNode put(TrieNode node, String str, int index) {
		if (index == str.length())
			return node;
		if (node == null)
			node = new TrieNode(str.charAt(index));
		char c = str.charAt(index);
		if (c < node.c) {
			node.left = put(node.left, str, index);
		} else if (c > node.c) {
			node.right = put(node.right, str, index);
		} else {
			node.mid = put(node.mid, str, index + 1);
			node.val += 1;
		}
		return node;
	}
}
