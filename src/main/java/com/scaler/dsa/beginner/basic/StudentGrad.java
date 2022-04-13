package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/**
 * Write a program to input from user five numbers(A, B, C, D & E) representing
 * marks of student in 5 subjects out of 100. You have to calculate percentage
 * and then Grade of each student.
 * 
 * If percentage >= 90% : Grade A If percentage >= 80% : Grade B If percentage
 * >= 70% : Grade C If percentage >= 60% : Grade D If percentage >= 40% : Grade
 * E If percentage < 40% : Grade F NOTE: You have to take the lowest integer of
 * percentage. E.g. 90.8% will be treated as 90%.
 */

public class StudentGrad {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		int d = s.nextInt();
		int e = s.nextInt();

		int percentage = (int) (a + b + c + d + e) * 100 / 500;

		if (percentage >= 90) {
			System.out.println(percentage + " " + "A");
		} else if (percentage >= 80) {
			System.out.println(percentage + " " + "B");
		} else if (percentage >= 70) {
			System.out.println(percentage + " " + "C");
		} else if (percentage >= 60) {
			System.out.println(percentage + " " + "D");
		} else if (percentage >= 40) {
			System.out.println(percentage + " " + "E");
		} else
			System.out.println(percentage + " " + "F");
	}

}