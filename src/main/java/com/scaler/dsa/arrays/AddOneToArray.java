package com.scaler.dsa.arrays;

import java.util.ArrayList;

/*
Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number 
( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. 
For example: for this problem, the following are some good questions to ask :
Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000
Input Format
First argument is an array of digits.
Output Format
Return the array of digits after adding one.

Input 1:[1, 2, 3]
Output 1:[1, 2, 4]

Explanation 1:
Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.

A={0, 3, 7, 6, 4, 0, 5, 5, 5}
 */
public class AddOneToArray {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(7);
		list.add(9);
		ArrayList<Integer> res = plusOne(list);
		System.out.println(res);
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

		int size = A.size();
		int carry = 1;
		for (int i = size - 1; i >= 0; i--) {

			int num = A.get(i);
			num += carry;
			carry = 0;

			if (num == 10) {
				num = 0;
				carry = 1;
			}

			A.set(i, num);
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		if (carry == 1)
			res.add(1);
		for (int x : A) {
			if (x == 0 && res.size() == 0)
				continue;
			res.add(x);
		}

		return res;

	}
}
