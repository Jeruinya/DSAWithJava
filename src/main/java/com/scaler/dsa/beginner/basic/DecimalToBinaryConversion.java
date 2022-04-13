package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class DecimalToBinaryConversion {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		long res = 0;
		while (n > 0) {
			long rem = n % 2;
			res = res * 10 + rem;
			n = n / 2;
		}

		System.out.println(res);
	}

}
