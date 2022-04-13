package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		long decimal = 0;
		int base = 1;
		while (n > 0) {
			long lastDigit = n % 10;
			decimal = decimal + base * lastDigit;
			n = n / 10;
			base = base * 2;
		}

		System.out.println(decimal);

	}

}
