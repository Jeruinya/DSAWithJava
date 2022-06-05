package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Write a program to input from user three numbers(A, B &C)
 * representing side lengths of a triangle. You have to print if the traingle is
 * "equilateral", "scalene" or "isosceles". Problem Constraints 1 <= A <= 100000
 * 1 <= B <= 100000 1 <= C <= 100000 Since all sides are different, hence it's a
 * scalene triangle. Since all sides are same, hence it's a equilateral
 * triangle. Since two sides are same, hence it's a isosceles triangle.
 */

public class CheckTypeOfTriangle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		//if (a >= 1 && a <= 100000 && b >= 1 && b <= 100000 && c >= 1 && c <= 100000) {
			if (a == b && a == c)
				System.out.println("equilateral");
			else if (a != b && a != c && b != c)
				System.out.println("scalene");
			else
				System.out.println("isosceles");
		//}
	}
}