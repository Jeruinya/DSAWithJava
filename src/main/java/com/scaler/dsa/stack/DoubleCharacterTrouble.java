package com.scaler.dsa.stack;

import java.util.Stack;

/*
Problem Description
You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", 
the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".
Keep performing this operation on the string until there are no more occurrences of the same
 consecutive characters and return the final string.

Problem Constraints
1 <= |A| <= 100000

Input Format
First and only argument is string A.

Output Format
Return the final string.

Input 1: A = abccbc
Input 2: A = ab

Output 1: "ac"
Output 2: "ab"

Explanation 1:
Remove the first occurrence of same consecutive characters. eg for a string "abbc", 
the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "ac".

Explanation 2:
 No removals are to be done.
 
 1-we need to keep track of the characters before the first occurrence of the similar character.
 2-We can do this using stack.
 3-we keeps pushing the characters in a stack , if the current character is equal to the top of the stack,we pop from 
   the stack since they present a pair of similar characters
 4- finally we print the stack in reverse.
 */
public class DoubleCharacterTrouble {

	public static void main(String[] args) {
		String A = "abccbc";
		System.out.println(removeConsecutiveChar(A));

	}

	private static String removeConsecutiveChar(String A) {
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < A.length(); i++) {

			if (!s.isEmpty() && A.charAt(i) == s.peek())
				s.pop();
			else
				s.push(A.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		s.forEach(ch -> sb.append(ch));

		return sb.toString();
	}

}
