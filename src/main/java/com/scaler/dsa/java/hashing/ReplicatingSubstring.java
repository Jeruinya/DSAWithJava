package com.scaler.dsa.java.hashing;

import java.util.HashMap;

/*
Problem Description

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as 
a concatenation of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 
similar strings "ab".

If it is possible, return 1, else return -1.

Problem Constraints
1 <= Length of string B <= 1000
1 <= A <= 1000
All the alphabets of S are lower case (a - z)

Input Format
First argument is an integer A.
Second argument is a string B.

Output Format
Your function should return 1 if it is possible to re-arrange the characters of the string B so that it 
can be represented as a concatenation of A similar strings. If it is not, return -1.

Input 1:
 A = 2
 B = "bbaabb"
Input 2:
 A = 1
 B = "bc"

Output 1: 1
Output 2: 1

Explanation 1:
 We can re-order the given string into "abbabb".

Explanation 2:
 String "bc" is already arranged.
 
A=2
B="aabab"

-> Divide B into A parts
-> N is the size of B so n%A==0. n should be divisible by A to make the String B into A parts.
-> Suppose the size of the string is B is 6 then we can divide this string into two parts of size 3.
->All the parts should have the same characters equal number of times.
->Every character should come as multiple of A.

And based on above below is the code using hashmap
 */
public class ReplicatingSubstring {

	public static void main(String[] args) {
		int A = 2;
		String B = "abab";
		System.out.println(solve(A, B));

	}

	public static int solve(int A, String B) {

		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < B.length(); i++) {
			if (hm.containsKey(B.charAt(i)))
				hm.put(B.charAt(i), hm.get(B.charAt(i)) + 1);
			else
				hm.put(B.charAt(i), 1);
		}
		for (char c : hm.keySet())
			if (hm.get(c) % A != 0)
				return -1;
		return 1;
	}
}
