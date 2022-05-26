package com.scaler.dsa.stack;

import java.util.Stack;

/*
Problem Description
Given a string A consisting only of '(' and ')'.
You need to find whether parentheses in A are balanced or not, if it is balanced then return 1 else return 0.
Problem Constraints
1 <= |A| <= 105
Input Format
First argument is an string A.
Output Format
Return 1 if parantheses in string are balanced else return 0.

Input 1: A = "(()())"
Input 2: A = "(()"
Output 1: 1
Output 2: 0
Explanation 1:
 Given string is balanced so we return 1.
Explanation 2:
 Given string is not balanced so we return 0.
 */
public class ParenthesisCheck {

	public static void main(String[] args) {
		String str = new String("(()())");
		int res = checkParenthesis(str);
		System.out.println(res);

	}

	public static int checkParenthesis(String A) {

		Stack<Character> s = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '(')
				s.push(A.charAt(i));
			else if (A.charAt(i) == ')' && s.isEmpty())
				return 0;
			else
				s.pop();
		}
		if (s.isEmpty())
			return 1;

		return 0;
	}

}
