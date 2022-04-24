package com.scaler.dsa.pattern;

/**
* 
* * 
* * * 
* * * * 
* * * * * 
* * * * * * 
* * * * * * * 
* * * * * * * * 
 */

import java.util.Scanner;

public class TrianlePatther1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*"+" ");
			}
			System.out.println();
		}

	}
}
