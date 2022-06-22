package com.scaler.dsa.recursion;

public class PrintNNumbersInIncreadingOrder {

	public static void main(String[] args) {
		int n = 20;
		printInc(n);

	}

	private static void printInc(int n) {
		if (n==1) {
			System.out.print(1+" ");
			return;
		}
			printInc(n - 1);
			System.out.print(n + " ");
	}

}
