package com.scaler.dsa.bitManipulation;

/*

Problem Description
Given an integer A. Unset B bits from the right of A in binary.
For eg:-A = 93, B = 4
A in binary = 1011101
A should become = 1010000 = 80. Therefore return 80.

Input 1:-A = 25 , B = 3
Input 2:-A = 37, B = 3

Output 1:-24
Output 2:-32

Explanation 1:-
A = 11001 to 11000
Explantio 2:-
A = 100101 to 100000
 */
public class UnsetXBitsFromRight {

	public static void main(String[] args) {
		int A=25, B=3;
		System.out.println((A>>B)<<B);

	}

}
