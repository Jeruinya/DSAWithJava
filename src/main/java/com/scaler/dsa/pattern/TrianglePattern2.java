package com.scaler.dsa.pattern;

/** 
       *
      **
     ***
    ****
   *****
  ******
 *******
********

 */
public class TrianglePattern2 {

	public static void main(String args[]) {
		int n=8;
		int i;
		for(i=0;i<n;i++) {
			for(int j=1;j<n-i;j++)
				System.out.print(" ");
			for(int k=0;k<=i;k++)
				System.out.print("*");
		System.out.println();
		}
	}

}
