package com.scaler.dsa.maths;

/*
Problem Description
You are given two non-negative integers, A and B. Find the value of the Least Common Multiple (LCM) of A and B.
LCM of two integers is the smallest positive integer divisible by both.

An efficient solution is based on the below formula for LCM of two numbers ‘a’ and ‘b’
   a x b = LCM(a, b) * GCD (a, b)
   LCM(a, b) = (a x b) / GCD(a, b)
 */
public class FindLCM {

	public static void main(String[] args) {
		int a=15,b=20;
		int lcm=a*b/gcd(a,b);
		System.out.println(lcm);
	}
	
	public static int gcd(int a, int b) {
		while(a!=b) {
			if(a>b)
				a=a-b;
			else
				b=b-a;
		}
		return a;
	}

}
