package com.scaler.dsa.pattern;

/*
********
*     *
*    *
*   *
*  *
* *
**
*

 
 
 */

public class FloydTriangleHollowPattern3 {

	public static void main(String[] args) {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (i == 1 || i == j || j == n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}