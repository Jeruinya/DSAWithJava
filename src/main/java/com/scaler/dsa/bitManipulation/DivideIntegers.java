package com.scaler.dsa.bitManipulation;

/*
Problem Description
Divide two integers without using multiplication, division and mod operator.
Return the floor of the result of the division.
Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
NOTE: INT_MAX = 2^31 - 1

Problem Constraints
-231 <= A, B <= 231-1
B != 0
Input Format
The first argument is an integer A denoting the dividend.
The second argument is an integer B denoting the divisor.

Output Format
Return an integer denoting the floor value of the division.

Input 1:
 A = 5
 B = 2
Input 2:
 A = 7
 B = 1

Output 1: 2
Output 2: 7

Explanation 1:
 floor(5/2) = 2
 
A=81, B=3
A/B=27

 i.e 1 0 0 1 0 1   find number of groups where bit is set.
 
 lets take 8 bit space
 3*2^7<=81  no so 7th bit will be 0
 3*2^6<=81  no so 6th bit will be 0
 3*2^5<=81  no so 5th bit will be 0
 3*2^4<=81  yes so 4th bit will be 1  and A=81-48=
 3*2^3<=33  yes so 3th bit will be 1 and A=33-24= 9
 3*2^2<=9  no so 2th bit will be 0
 3*2^1<=9  yes so 1th bit will be 1  and A=9-6=3
 3*2^0<=3  yes so 0th bit will be 1 and A=3-3=0
 

 */
public class DivideIntegers {

	public static void main(String[] args) {
		System.out.println(divideNumberEff(5, 2));
		System.out.println(divideNumberNaive(5, 2));

	}

	private static int divideNumberNaive(int A, int B) {
		int count = 0;
		while (A >= B) {
			A = A - B;
			count++;
		}
		return count;
	}

	//When revisit practice on this
	public static int divideNumberEff(int A, int B) {
		long n = A, m = B;
		// determine sign of the quotient
		int sign = 1;
		if (n < 0)
			sign *= -1;
		if (m < 0)
			sign *= -1;
		// remove sign of operands
		n = Math.abs(n);
		m = Math.abs(m);
		// q stores the quotient in computation
		long q = 0;
		// test down from the highest bit
		// accumulate the tentative value for valid bits
		for (int i = 31; i >= 0; i--) {
			if ((m << i) <= n) {
				n = n - (m << i);
				q |= (long) 1 << i;
			}
		}
		// assign back the sign
		if (sign < 0)
			q = -q;
		// check for overflow and return
		if (q > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else
			return (int) q;
	}
}
