package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description You are given 3 integer angles(in degrees) A, B and C of
 * a triangle. You have to tell whether the triangle is valid or not. A triangle
 * is valid if sum of its angles equals to 180. Problem Constraints 1 <= A, B, C
 * <= 180
 */

public class TriangleCheck {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		if (a + b + c == 180)
			System.out.print(1);
		else
			System.out.print(0);
	}
}