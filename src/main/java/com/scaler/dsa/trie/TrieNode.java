package com.scaler.dsa.trie;

import java.util.HashMap;

public class TrieNode {
	char data;
	boolean isTerminal;
	HashMap<Character, TrieNode> hm;

	TrieNode(char d) {
		data = d;
		isTerminal = false;
		hm = new HashMap<>();
	}

}
