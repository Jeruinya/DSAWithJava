package com.scaler.dsa.java.hashing;

/*
Problem Description
Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.
What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.


Problem Constraints
1 <= A <= 2 * 109
Input Format
The first and only argument is an integer A.
Output Format
Return 1 if integer A is COLORFUL else return 0.

Input 1: A = 23
Input 2: A = 236

Output 1: 1
Output 2: 0

Explanation 1:
 Possible Sub-sequences: [2, 3, 23] where
 2 -> 2 
 3 -> 3
 23 -> 6  (product of digits)
 This number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Explanation 2:
 Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 2 -> 2 
 3 -> 3
 6 -> 6
 23 -> 6  (product of digits)
 36 -> 18  (product of digits)
 236 -> 36  (product of digits)
 This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckColourFullNumber {

	public static void main(String[] args) {
		int n = 3245;
		int res = colorFul(n);
		System.out.println(res);

	}

	public static int colorFul(int A) {

		List<Integer> list = new ArrayList<>();
		Set<Integer> hs = new HashSet<>();

		while (A > 0) {
			int rem = A % 10;
			list.add(rem);
			A = A / 10;
		}
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			int prod = 1;
			for (int j = i; j < list.size(); j++) {
				prod = prod * list.get(j);
				if (hs.contains(prod))
					return 0;
				else
					hs.add(prod);
			}
		}
		return 1;

	}

}
