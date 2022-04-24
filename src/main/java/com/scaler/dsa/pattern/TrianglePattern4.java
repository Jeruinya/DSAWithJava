package com.scaler.dsa.pattern;
/*

******
 *****
  ****
   ***
    **
     *

 */

public class TrianglePattern4 {
	public static void main(String[] args) {
		int n = 6;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <i; j++)
				System.out.print(" ");
			for(int k=0;k<n-i;k++)
				System.out.print("*");
			System.out.println();
		}

	}

}
