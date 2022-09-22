package com.scaler.dsa.stack;

import java.util.Stack;

/*
Problem Description
An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression 
in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Problem Constraints
1 <= N <= 105
Input Format
The only argument given is string array A.
Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.

Input 1:    A =   ["2", "1", "+", "3", "*"]
Input 2:   A = ["4", "13", "5", "/", "+"]

Output 1:   9
Output 2:   6

Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {

	public static void main(String[] args) {
		String A[] = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(A));

	}

	public static int evalRPN(String[] A) {

		Stack<Integer> s = new Stack<>();

		for (String opr : A) {
			if (opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/")) {
				int num1 = s.pop();
				int num2 = s.pop();

				switch (opr) {
				case "+":
					int sum = num1 + num2;
					s.push(sum);
					break;
				case "-":
					int sub = num2 - num1;
					s.push(sub);
					break;
				case "*":
					int mul = num1 * num2;
					s.push(mul);
					break;
				case "/":
					int div = num2 / num1;
					s.push(div);
					break;

				}

			} else {
				s.push(Integer.parseInt(opr));
			}
		}

		return s.pop();
	}
}
