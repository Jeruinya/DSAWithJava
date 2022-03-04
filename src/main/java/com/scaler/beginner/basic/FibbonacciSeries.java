package com.scaler.beginner.basic;

import java.util.Scanner;

public class FibbonacciSeries {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int n1 = 0, n2 = 1;
		while (n > 0) {
			System.out.print(n1 + " ");
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			n--;
		}

	}
}