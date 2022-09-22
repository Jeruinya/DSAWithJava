package com.scaler.dsa.stack;

/*
Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.

Input 1: A = {([])}
Input 2: A = (){
Input 3: A = ()[] 

Output 1: 1 
Output 2: 0 
Output 3: 1 


Example Explanation
You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */
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
