package com.scaler.dsa.trie;

/*
Given a text A and array of words B, you have to check whether words of array B is present in text A or not.
if present print yes else print no.

String text="the cute cat jumps over a wall";
String B[]={"cute cat","ver","cat","garden","wan"};
"cute cat"= yes
cat=yes
ver= yes
cat = yes
garden = yes
wan= yes

Approach:

Use the KMP algorithm for every phrase to solve it. Time complexity- O(W*N) where n is the length of test and 
and w is the length of array B

 */
public class PatternMatch {

	public static void main(String[] args) {
		String text = "the cute cat jumps over a wall";
		String B[] = { "cute cat", "ver", "cat", "garden", "wan" };

	}

}
