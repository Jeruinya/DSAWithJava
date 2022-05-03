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
 */
public class AAndBAndModulo {

	public static void main(String[] args) {
		
		int A=5,B=7;
	      System.out.println(Math.abs(A-B));
	}
}
