package com.scaler.dsa.stack;

/*
Problem Description
Given two strings A and B. Each string represents an expression consisting of lowercase English 
alphabets, '+', '-', '(' and ')'.
The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.

Problem Constraints
1 <= length of the each String <= 100
Input Format
The given arguments are string A and string B.
Output Format
Return 1 if they represent the same expression else return 0.

Input 1:
 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:
 A = "a-b-(c-d)"
 B = "a-b-c-d"

Output 1: 1
Output 2: 0

Explanation 1:
 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B. 

Explanation 2:
 Both the expression are different.
 */
import java.util.Arrays;
import java.util.Stack;

public class CheckTwoBracketExpressionsAreSame {

	static int MAX_CHAR = 26;

	public static void main(String[] args) {
		String A = "a-b-(c-d)";
		String B = "a-b-c-d";
		System.out.println(areExpressionsSame(A, B));
		System.out.println(areExpressionsSameNaive(A, B));

	}

	public static int areExpressionsSame(String A, String B) {
		if (areSame(A, B))
			return 1;
		return 0;
	}

	public static Boolean areSame(String expr1, String expr2) {
		int v[] = new int[MAX_CHAR];
		eval(expr1, v, true);
		eval(expr2, v, false);
		for (int i = 0; i < MAX_CHAR; i++)
			if (v[i] != 0)
				return false;

		return true;
	}

	public static void eval(String s, int v[], Boolean add) {
		Stack<Boolean> stk = new Stack<Boolean>();
		stk.push(true);

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);

			if (c == '+' || c == '-') {
				i++;
				continue;
			}
			if (c == '(') {
				if (adjSign(s, i))
					stk.push(stk.peek());
				else
					stk.push(!stk.peek());
			} else if (c == ')')
				stk.pop();
			else {
				if (stk.peek())
					v[c - 'a'] += (adjSign(s, i) ? add ? 1 : -1 : add ? -1 : 1);
				else
					v[c - 'a'] += (adjSign(s, i) ? add ? -1 : 1 : add ? 1 : -1);
			}
			i++;
		}
	}

	static Boolean adjSign(String s, int i) {
		if (i == 0)
			return true;
		if (s.charAt(i - 1) == '-')
			return false;
		return true;
	}

	public static int areExpressionsSameNaive(String A, String B) {
		char[] strA = calculateSigns(A);
		char[] strB = calculateSigns(B);

		for (int i = 0; i < strA.length; i++) {
			if (strA[i] != strB[i]) {
				return 0;
			}
		}

		return 1;
	}

	public static char[] calculateSigns(String str) {
		Stack<Character> globalOperators = new Stack<Character>();
		char[] outArr = new char[26];
		Arrays.fill(outArr, '+');
		int n = str.length();
		char localOperator = '+'; // This is to keep track of the sign comes immediately before the number
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);

			if (ch == '-' || ch == '+') {
				if (globalOperators.isEmpty()) {
					localOperator = ch;
				} else {
					localOperator = giveProperSign(globalOperators.peek(), ch);
				}
				continue;
			}

			if (ch == '(') {
				globalOperators.push(localOperator);
				continue;
			}

			if (ch == ')') {
				globalOperators.pop();
				continue;
			}

			outArr[ch - 'a'] = localOperator;
		}

		return outArr;
	}

	public static char giveProperSign(char operator1, char operator2) {
		if ((operator1 == '-' && operator2 == '+') || (operator1 == '+' && operator2 == '-')) {
			return '-';
		}

		return '+';
	}
}
