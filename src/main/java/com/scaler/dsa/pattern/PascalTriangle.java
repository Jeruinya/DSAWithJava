package com.scaler.dsa.pattern;

import java.util.Scanner;

/*
       1 
      1 1 
     1 2 1 
    1 3 3 1 
   1 4 6 4 1 
  1 5 10 10 5 1 
 1 6 15 20 15 6 1 
1 7 21 35 35 21 7 1 

 */

public class PascalTriangle {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		int n=5;
		for (int i = 1; i <= n; i++) {
			for (int s = 1; s <= n - i; s++) {
				System.out.print(" ");
			}
			int C = 1;
			for (int j = 1; j <= i; j++) {
				System.out.print("*" + " ");
				C = C * (i - j) / j;
			}
			System.out.println();
		}
	}
}
