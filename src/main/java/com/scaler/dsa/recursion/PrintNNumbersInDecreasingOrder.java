package com.scaler.dsa.recursion;

public class PrintNNumbersInDecreasingOrder {

	public static void main(String[] args) {
		int n = 5;
		printInc(n);

	}

	private static void printInc(int n) {
		int x = n;
		if (x >= 1) {
			System.out.print(n + " ");
			printInc(n - 1);
			x--;
		}

	}

}
