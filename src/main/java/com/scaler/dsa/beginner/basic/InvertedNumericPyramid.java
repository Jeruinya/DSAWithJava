package com.scaler.dsa.beginner.basic;

import java.util.Scanner;
/*
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1

 */
public class InvertedNumericPyramid {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = n; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
				if (i != j)
					System.out.print(" ");
			}
			System.out.println();
		}

	}
}