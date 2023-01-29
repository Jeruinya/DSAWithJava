package com.scaler.dsa.matrix;

/*
Identity Matrix is a square matrix in which all the elements of the principal or main diagonal 
are 1’s and all other elements are zeros. In the below image, every matrix is an Identity Matrix. 

example:
		 1 0 0 0
         0 1 0 0
         0 0 1 0
         0 0 0 1
 */
public class CheckAMatricIsIdentity {

	public static void main(String args[]) {
		int A[][] = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println(isIdentityMatrix(A));
	}

	private static int isIdentityMatrix(int[][] A) {
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[0].length; j++)
				if ((i == j && A[i][j] != 1) || (i != j
				&& A[i][j] != 0))
					return 0;
		return 1;
	}

}
