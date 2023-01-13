package com.scaler.dsa.pattern;

import java.util.Scanner;

/*
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
16 17 18 19 20 21
22 23 24 25 26 27 28
29 30 31 32 33 34 35 36

 */

public class NumberIncPrint {

	public static void main(String[] args) {

		int val = 1;
		int n = 5;
		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print(val + " ");
				val++;
			}
			System.out.println();
		}
	}
}
