package com.scaler.dsa.maths;

/*
Problem Description
You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
Problem Constraints
1 <= A, B <= 109
Input Format
First argument is an integer A.
Second argument is an integer B.
Output Format
Return an integer maximum value of X as descibed above.

Input 1: A = 30  B = 12
Input 2: A = 5  B = 10

Output 1: 5
Output 2: 1
Explanation 1:
 All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30). 
 The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
Explanation 2:
 1 is the only value such that A%5 == 0 and gcd(1,10) = 1
 
 Given two numbers A and B, find a number X such that 1-A%X=0 and 2-gcd(B,X) =1
 
 so basically its needs to find the largest co-prime from number A and that will be the answer.
 A=300 = 2^2 * 3^1*5^2
 B=18 = 2*3^2
 
 A=A/gcd(A,B)   
 A=300/gcd(300,18)=300/6=50
 A=50=2*5^2
 
 A=50/gcd(50,18)=25
 A=25
 gcd(A,B)=gcd(25,18)=1
 
 
 */
public class LargestCoprimeDivisor {

	public static void main(String[] args) {
		int A = 300;
		int B = 18;
		while (getGcd(A, B) != 1) {
			A = A / getGcd(A, B);
		}
		System.out.println(A);
	}

	private static int getGcd(int a, int b) {
		int a1, b1;
		while (a != 0) {
			a1 = b % a;
			b1 = a;
			a = a1;
			b = b1;
		}
		return b;
	}

}
