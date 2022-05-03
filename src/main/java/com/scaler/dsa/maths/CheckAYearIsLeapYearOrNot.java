package com.scaler.dsa.maths;

/*
Problem Description
Given an integer A representing a year, Return 1 if it is a leap year else, return 0.
A year is a leap year if the following conditions are satisfied:
	1-The year is multiple of 400.
	OR
	2-Else the year is multiple of 4 and not multiple of 100.
 */
public class CheckAYearIsLeapYearOrNot {

	public static void main(String[] args) {
		int A = 2020;
		if (A % 400 == 0 || (A % 4 == 0 && A % 100 != 0))
			System.out.println("Leap Year");
		else
			System.out.println("Not a leap year");
	}

}
