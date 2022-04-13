package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Write a program to input T numbers(N) from user and print
 * the sum of the digits of the given numbers. Problem Constraints 1 <= T <=
 * 1000 0 <= N <= 100000000
 * 
 */

public class SumOfDigitOfMultipleNum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			if (a == 0) {
				System.out.println(0);
			} else {
				int sum = 0;
				while (a > 0) {
					int rem = a % 10;
					sum = sum + rem;
					a = a / 10;
				}
				System.out.println(sum);
			}
		}
	}
}