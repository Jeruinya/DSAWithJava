package com.dsa.scaler.matrix;

import java.util.Arrays;

public class TransposeOfMatrix {

	public static void main(String[] args) {

		int A[][] =
			{
			  {21, 62, 16, 44, 55, 100, 16, 86, 29},
			  {62, 72, 85, 35, 14, 1, 89, 15, 73},
			  {42, 44, 30, 56, 25, 52, 61, 23, 54},
			  {5, 35, 12, 35, 55, 74, 50, 50, 80},
			  {2, 65, 65, 82, 26, 36, 66, 60, 1},
			  {18, 1, 16, 91, 42, 11, 72, 97, 35},
			  {23, 57, 9, 28, 13, 44, 40, 47, 98}
			  };
		
		int m=A.length;
        int n=A[0].length;

        int b[][]=new int [n][m];

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            		b[i][j]=A[j][i];

        for(int i=0;i<b.length;i++)
        	System.out.println(Arrays.toString(b[i]));
	}

}
