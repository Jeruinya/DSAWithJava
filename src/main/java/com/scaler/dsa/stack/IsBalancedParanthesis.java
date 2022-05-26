package com.scaler.dsa.stack;

import java.util.Stack;

public class IsBalancedParanthesis {

	public static void main(String[] args) {
		String str = "{([])}";
		int res = isParanthesisBalanced(str);
		System.out.println(res);

	}

	public static int isParanthesisBalanced(String A) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			if (s.isEmpty())
				s.push(A.charAt(i));
			else if ((s.peek() == '(' && A.charAt(i) == ')') || (s.peek() == '{' && A.charAt(i) == '}')
					|| (s.peek() == '[' && A.charAt(i) == ']'))
				s.pop();
			else
				s.push(A.charAt(i));
		}
		return s.isEmpty() ? 1 : 0;
	}

}
