package com.scaler.dsa.maths;
/*
Problem Description
Given an integer A, find and return the Ath magic number.
A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
Input Format
The only argument given is integer A.

Output Format
Return the Ath magic number.

Example Input 1: A = 3
Example Input 2: A = 10----1010---5^4+5^3*0+5^2*1+5^1*0===650

Example Output 1: 30
Example Output 2: 650

Term   Number			Binary Representation
1		5^1				1
2		5^2				10
3		5^2+5^1			11
4		5^3				100
5		5^3+5^1			101
6		5^3+5^2			110
7		5^3+5^2+5^1		111
8		5^4				1000
9		5^4+5^1			1001
10		5^4+5^2			1010
11		5^4+5^2+5^1		1011
12		5^4+5^3			1100
13		5^4+5^3+5^1		1101
14		5^4+5^3+5^2+5^1 1111

 */

public class FindnthMagicNumber {

	public static void main(String[] args) {
		int A = 4;
		System.out.println(nthMagicNumber(A));
	}

	private static int nthMagicNumber(int A) {
		int pow = 5;
		int ans = 0;
		while (A > 0) {
			ans = ans + (A & 1) * pow;
			pow = pow * 5;
			A = A >> 1;
		}
		return ans;
	}
}