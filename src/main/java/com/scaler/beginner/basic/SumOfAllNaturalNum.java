package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description Write a program to find sum all Natural numbers from 1 to
 * N where you have to take N as input from user Problem Constraints 1 <= N
 * <=1000
 */

public class SumOfAllNaturalNum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		if (n >= 1 && n <= 1000) {
			sum = n * (n + 1) / 2;
		}
		System.out.println(sum);
	}
}