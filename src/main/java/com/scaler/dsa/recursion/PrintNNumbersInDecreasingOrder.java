package com.scaler.dsa.recursion;

public class PrintNNumbersInDecreasingOrder {

	public static void main(String[] args) {
		int n = 5;
		printInc(n);
	}
	private static void printInc(int n) {
		
		if (n==0) 
			return;
			System.out.print(n + " ");
			printInc(n - 1);
	}
}
