package com.dsa.matrix;

import java.util.Arrays;

public class TransposeOfMatrix {

	public static void main(String[] args) {

		int a[][] = { { 2, 3 }, { 1, 2 }, { 9, 8 } };
		int b[][]=new int[a.length][a[0].length];
		

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                b[i][j] = a[j][i];
            }
        }
        for(int i=0;i<b.length;i++)
        	System.out.println(Arrays.toString(b[i]));
	}

}
