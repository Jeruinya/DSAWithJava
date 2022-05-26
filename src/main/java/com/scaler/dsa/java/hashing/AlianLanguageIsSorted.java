package com.scaler.dsa.java.hashing;

/*
Problem Description
Surprisingly, in an alien language, they also use English lowercase letters, 
but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet 
denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

Input Format
The first argument is a string array A of size N.
The second argument is a string B of size 26, denoting the order.
Output Format
Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

Input 1:
 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:
 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"

Output 1: 1
Output 2: 0

Explanation 1:
 The order shown in string B is: h < s < i for the given words. So return 1.
Explanation 2:
 "none" should be present after "no". Return 0.
 
 
 Algorithm

1-Initialize a hashmap/array to record the relations between each letter and its ranking in order.
2-Iterate over words and compare each pair of adjacent words.
	->Iterate over each letter to find the first different letter between words[i] and words[i + 1].
		--If words[i + 1] ends before words[i] and no different letters are found, then we need to return false because words[i + 1] should come before words[i] (for example, apple and app).
		--If we find the first different letter and the two words are in the correct order, then we can exit from the current iteration and proceed to the next pair of words.
		--If we find the first different letter and the two words are in the wrong order, then we can safely return false.
3-If we reach this point, it means that we have examined all pairs of adjacent words and that they are all sorted. Therefore we can return true.
 */
public class AlianLanguageIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
