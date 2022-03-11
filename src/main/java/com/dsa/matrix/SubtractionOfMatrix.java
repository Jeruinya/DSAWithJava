package com.dsa.matrix;

import java.util.Arrays;

public class SubtractionOfMatrix {

	public static void main(String[] args) {
		int A[][] = { { 50, 20, 30 },
	                { 60, 30, 10 },
	                { 30, 80, 10 } };

		int B[][] = 	{ { 10, 10, 5 },
		                { 20, 10, 12 },
		                { 23, 21, 12 } };
		
		int c[][]=new int[3][3];
		
		for(int i=0;i<3;i++) 
			for(int j=0;j<3;j++) 
				c[i][j]=A[i][j]-B[i][j];
		
		for(int i=0;i<3;i++) {
			//for(int j=0;j<3;j++) {
				System.out.print(Arrays.toString(c[i])); 
			//}
			//System.out.println();
		}
	}

}
