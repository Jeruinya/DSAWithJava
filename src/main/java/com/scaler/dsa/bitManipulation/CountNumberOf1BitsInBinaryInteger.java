package com.scaler.dsa.bitManipulation;

/**
 
Problem Description:
Write a function that takes an integer and returns the number of 1 bits it has.
Problem Constraints: 1 <= A <= 109
Input Format :First and only argument contains integer A

Output Format: Return an integer as the answer

Input1:11
Output1:3
 
 */

public class CountNumberOf1BitsInBinaryInteger {

	public static void main(String[] args) {
		int A = 29;
		int count = 0;
		while (A > 0) {
			int rem = A % 2;
			if (rem == 1)
				count++;
			A = A / 2;
		}
		System.out.println(count);
	}
}
