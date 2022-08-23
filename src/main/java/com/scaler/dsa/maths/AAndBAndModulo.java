package com.scaler.dsa.maths;

/*
 Problem Description
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
Here we have to find value of M so if we take remainder with A and B then its same.

Problem Constraints
1 <= A, B <= 109
A != B

A%M=B%m
A%M-B%M=0
(A%M-B%M)%M=0
(A-B)%M=0
so M is (A-B)


there could be three cases:
1:A>B
2:B>A 
3:A=B

1: A>B

B=B
B=A-(A-B)
B%A(A-B)= A%(A-B)-(A-B)%(A-B)
B%(A-B)=A%(A-B)

So to make both equal the M value should be A-B

1: B>A

A=A
A=B-(B-A)
A%(B-A)= B%(B-A)-(B-A)%(B-A)
A%(B-A)=B%(B-A)

So to make both equal the M value should be B-A


 */
public class AAndBAndModulo {

	public static void main(String[] args) {
		
		int A=5,B=7;
	      System.out.println(Math.abs(A-B));
	}
}
