package com.dsa.scaler.matrix;

public class CheckTwoMatrixAreEqual {

	public static void main(String[] args) {
		//int A[][] = { { 50, 20, 30 }, { 60, 30, 10 }, { 30, 80, 10 } };

		//int B[][] = { { 10, 10, 5 }, { 20, 10, 12 }, { 23, 21, 12 } };
		
		int A[][] = { { 50, 20, 30 }, { 60, 30, 10 }, { 30, 80, 10 } };

		int B[][] = { { 50, 20, 30 }, { 60, 30, 10 }, { 30, 80, 10 } };
		
		int flag =1;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				if(A[i][j]!=B[i][j]) {
					flag=0;
					break;
				}
			}
		}
		if(flag==1)
			System.out.println("Matrices are Equal");
		else
				System.out.println("Matrices are not Equal");
	}

}
