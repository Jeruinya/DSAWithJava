package com.scaler.dsa.maths;

/*
Problem Description
You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B 
inclusive is taken (GCD(A, A+1, A+2 ... B)).
As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.

You have to return the value of GCD found.
The greatest common divisor of 2 numbers, A and B, is the largest number, D that divides both A and B perfectly.
Problem Constraints
1 <= A <= B <= 10100
Input Format
First argument is a string denoting A.
Second argument is a string denoting B.
Output Format
Return a string which contains the digits of the integer which represents the GCD. 
The returned string should not have any leading zeroes.
Example Input A = "1" B = "3"
Example Output
1
Example Explanation
Greatest divisor that divides both 1 and 3 is 1.

Observations:

1-if A and B both are equals just then gcd will be A or B.
2-if A!=B the gcd(A,A+1,A+2,A+3,......B)

P=X*D      Q= Y*D
P-Q=(X-Y)*D
P=Q+1
Q+1-Q=D
D=1

Hence GCD of consecutive numbers is always one.
 */
public class GCDOfConsecutiveNumbers {

	public static void main(String[] args) {
		String A = "1";
		String B = "3";
		String res = getGcdOfConsecutiveNo(A, B);
		System.out.println(res);

	}

	private static String getGcdOfConsecutiveNo(String A, String B) {
		if (A.equals(B))
			return A;

		return "1";
	}

}
