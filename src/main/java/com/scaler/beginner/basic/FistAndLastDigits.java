package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Write a program to input T numbers(N) from user and print
 * first and last digits of the given numbers. Problem Constraints 1 <= T <=
 * 1000 0 <= N <= 100000000
 */

public class FistAndLastDigits {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
			int a = arr[i];
			int last = a % 10;
			a = a / 10;
			int rem = 0;
			if (a == 0 || a == 1 || a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8 || a == 9) {
				System.out.println(a + " " + a);
				continue;
			}
			while (a > 0) {
				rem = a % 10;
				a = a / 10;
			}
			System.out.println(rem + " " + last);
		}
	}
}
