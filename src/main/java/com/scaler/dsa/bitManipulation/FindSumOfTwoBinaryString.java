package com.scaler.dsa.bitManipulation;

/**
Problem Description
Given two binary strings, return their sum (also a binary string).
Example:
a = "100"
b = "11"
Return a + b = "111".
 */

public class FindSumOfTwoBinaryString {

	public static void main(String[] args) {
		String A = "1000";
		String B = "110";

		String res = "";

		int i = A.length()-1;
		int j = B.length()-1;
		long s = 0;
		while (i >= 0 || j >= 0 || s == 1) {
			s =s+ (i >= 0 ? A.charAt(i)-'0' : 0);
			s =s+ (j >= 0 ? B.charAt(j)-'0' : 0);
			res = s % 2+res;
			s = s / 2;
			i--;
			j--;

		}
		System.out.println(res);
	}
}
