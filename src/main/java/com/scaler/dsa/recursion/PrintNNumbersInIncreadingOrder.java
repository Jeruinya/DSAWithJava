package com.scaler.dsa.recursion;

public class PrintNNumbersInIncreadingOrder {

	public static void main(String[] args) {
		int n = 5;
		printInc(n);

	}

	private static void printInc(int n) {
		int x=1;
		if (x<=n) {
			printInc(n - 1);
			System.out.print(n + " ");
			x++;
		}
	}

}
