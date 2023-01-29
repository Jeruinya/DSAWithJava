package com.scaler.dsa.matrix;

import java.util.Scanner;

/*
Given a matrix of size N*M and we have Q queries, find the sum of a given submatrix. each query will have 4 
integers x1,y1,x2,y2 denoting the sub matrix.
	1 2 3 4
	4 5 6 7
	8 9 10 11
Query (x1,y1) (x2,y2)=(1,0) (2,2)  these are the coordinates of sub matrix and needs to find the sum of this sub matrix

Building a 2D prefix sum matrix to optimize the time complexity.
PS[i,j]=hold the sum of sub matrix from (0,0)  to (i,j).

To build a PS we first needs to 
	-fill  first row and first column just like 1 D array.
	-Then fill other points of (i,j) like ps[i,j]=ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1]+A[i][j]
 */
public class R_SumofSubmatricesForQQueries {

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		int a = 1, b = 0, c = 2, d = 2;
		int sum = subMatrixSum(A, a, b, c, d);
		System.out.println(sum);
		int n = A.length;
		int m = A[0].length;

		int ps[][] = new int[n][m];
		ps[0][0] = A[0][0];
		for (int j = 1; j < m; j++)
			ps[0][j] = ps[0][j - 1] + A[0][j];

		for (int i = 1; i < n; i++)
			ps[i][0] = ps[i - 1][0] + A[i][0];

		for (int i = 1; i < n; i++)
			for (int j = 1; j < m; j++)
				ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + A[i][j];
		
		Scanner s= new Scanner(System.in);
		int Q= s.nextInt();
		while(Q>0) {
			
			int x1=s.nextInt();
			int y1=s.nextInt();
			int x2=s.nextInt();
			int y2=s.nextInt();
			int submatrixSum=ps[x2][y2]-ps[x2][y1-1]-ps[x1-1][y2]+ps[x1-1][y1-1];
			System.out.println(submatrixSum);
			Q--;
			
			
		}

	}

	// TC-O(N*M) for 1 query and O(Q*N*M) for Q queries, SC=O(1)
	// This will working fine for 1 query
	public static int subMatrixSum(int[][] A, int x1, int y1, int x2, int y2) {

		int sum = 0;
		for (int i = x1; i <= x2; i++)
			for (int j = y1; j <= y2; j++)
				sum = sum + A[i][j];
		return sum;
	}

}
