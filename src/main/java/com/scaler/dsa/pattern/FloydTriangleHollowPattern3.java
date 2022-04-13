package com.scaler.dsa.pattern;

import java.util.Scanner;

public class FloydTriangleHollowPattern3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (i == 1 || i == j || j == n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}