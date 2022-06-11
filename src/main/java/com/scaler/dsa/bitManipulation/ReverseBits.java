package com.scaler.dsa.bitManipulation;
/*
Problem Description
Reverse the bits of an 32 bit unsigned integer A.

Input Format
First and only argument of input contains an integer A.
Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.

Input 1: 0
Input 2: 3
Output 1: 0
Output 2: 3221225472
 */

public class ReverseBits {

	public static void main(String[] args) {

		long a = 23;
		long l = reverseBits(a);
		System.out.println(l);
		
		long l1 = reverse(a);
		System.out.println(l1);
	}

	public static long reverseBits(long a) {
		long rev = 0;
		for (int i = 0; i < 32; i++) {
			if (a % 2 == 1) {
				rev += 1;
			}

			a >>= 1;
			if (i < 31)
				rev <<= 1;
		}
		return rev;
	}
	
	public static long reverse(long A) {
	    long rev = 0;
	    
	    for (int i = 0; i < 32; i++) {
	        rev <<= 1;
	        if ((A & (1 << i)) != 0)
	            rev |= 1;
	    }
	    
	    return rev;
	    
	}
}
