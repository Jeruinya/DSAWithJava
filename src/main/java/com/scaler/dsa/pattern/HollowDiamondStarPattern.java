package com.scaler.dsa.pattern;
/*
* * * * * * * * * * * * * * * * 
* * * * * * *     * * * * * * * 
* * * * * *         * * * * * * 
* * * * *             * * * * * 
* * * *                 * * * * 
* * *                     * * * 
* *                         * * 
*                             * 
*                             * 
* *                         * * 
* * *                     * * * 
* * * *                 * * * * 
* * * * *             * * * * * 
* * * * * *         * * * * * * 
* * * * * * *     * * * * * * * 
* * * * * * * * * * * * * * * * 
  
 */

public class HollowDiamondStarPattern {

	public static void main(String[] args) {
		int n = 8;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++)
				System.out.print("*" + " ");
			for (int k = 0; k < 2 * i; k++)
				System.out.print(" " + " ");
			for (int l = 0; l < n - i; l++)
				System.out.print("*" + " ");
			System.out.println();
		}
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j <= i; j++) {
				System.out.print("*" + " ");
				count++;
			}
			for (int k = count; k < n; k++)
				System.out.print(" " + " ");

			for (int k = 0; k < n - i - 1; k++)
				System.out.print(" " + " ");
			for (int k = 0; k <= i; k++)
				System.out.print("*" + " ");

			System.out.println();
		}

	}
}
