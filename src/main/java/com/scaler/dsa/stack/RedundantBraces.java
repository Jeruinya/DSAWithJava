package com.scaler.dsa.stack;

import java.util.Stack;

/*
Problem Description
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
Check whether A has redundant braces or not.
NOTE: A will be always a valid expression and will not contain any white spaces.

Problem Constraints
1 <= |A| <= 105

Input Format
The only argument given is string A.

Output Format
Return 1 if A has redundant braces else, return 0.

Input 1: A = "((a+b))"
Input 2: A = "(a+(a+b))"

Output 1: 1
Output 2: 0

Explanation 1:
 ((a+b)) has redundant braces so answer will be 1.

Explanation 2:
 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {

	public static void main(String[] args) {
		String s = "((a+b))";
		System.out.println(braces(s));

	}

	public static int braces(String A) {

		if (A.length() == 1)
			return 0;

		Stack<Character> s = new Stack<>();

		for (int i = 0; i < A.length(); i++) {
			char a = A.charAt(i);
			if (a == '(' || a == '/' || a == '*' || a == '+' || a=='-')
				s.push(a);
			if (a == ')') {
				int count = 0;
				while (s.peek() != '(') {
					count++;
					s.pop();
				}
				s.pop();

				if (count == 0)
					return 1;

			}
		}
		return 0;
	}
}
