package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class DecimalToBinaryConversion {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int bits[] = new int[100];
		int i = getDecimalToBinaryUsingArray(n, bits);
		for (int j = i - 1; j >= 0; j--)
			System.out.print(bits[j] + " ");

		System.out.println();
		int res = getDecimalToBinaryUsingPow(n);
		System.out.println(res);

		System.out.println();
		String res1 = getDecimalToBinaryUsingString(n);
		System.out.println(res1);
	}

	// Not working needs to look later
	public static String getDecimalToBinaryUsingString(int n) {
		String res = "";
		while (n > 0) {
			int rem = n % 2;
			res = rem + res;
			n = n / 2;
		}
		return res;
	}

	public static int getDecimalToBinaryUsingPow(int n) {
		int res = 0, c = 0;
		while (n > 0) {
			int rem = n % 2;
			int pow = (int) Math.pow(10, c);
			res = res + pow * rem;
			n = n / 2;
			c++;
		}
		return res;
	}

	// using array
	private static int getDecimalToBinaryUsingArray(int n, int[] bits) {
		int i = 0;
		while (n > 0) {
			bits[i] = n % 2;
			n = n / 2;
			i++;
		}
		return i;
	}
}
