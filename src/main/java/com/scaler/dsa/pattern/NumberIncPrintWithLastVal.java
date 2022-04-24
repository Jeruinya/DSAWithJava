package com.scaler.dsa.pattern;
import java.util.Scanner;

/*
1 
2 3 
4 5 6 
7 8 

 */

public class NumberIncPrintWithLastVal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int final_val = sc.nextInt();
		int val = 1;

		for (int i = 1; val <= final_val; i++) {

			for (int col = 1; col <= i; col++) {
				System.out.print(val + " ");
				++val;
				if (val > final_val) {
					break;
				}
			}
			System.out.println();
		}
	}
}