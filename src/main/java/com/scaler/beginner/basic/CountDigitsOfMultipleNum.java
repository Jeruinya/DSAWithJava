package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Write a program to input T numbers(N) from user and print
 * count of digits of the given numbers.
 * 
 * Problem Constraints 1 <= T <= 100 0 <= N <= 100000000
 */

public class CountDigitsOfMultipleNum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			if (a == 0) {
				System.out.println(1);
			} else {
				int count = 0;
				while (a > 0) {
					count++;
					a = a / 10;
				}
				System.out.println(count);
			}
		}
	}
}