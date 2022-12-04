package com.scaler.dsa.dp;

import java.util.ArrayList;

/*
Print all the paths from (0,0)  to (m-1,n-1) in the grid of m*n.

[0, 1, 2, 2, 2]
[0, 0, 0, 1, 2]
----------------
[0, 1, 1, 2, 2]
[0, 0, 1, 1, 2]
----------------
[0, 1, 1, 1, 2]
[0, 0, 1, 2, 2]
----------------
[0, 0, 1, 2, 2]
[0, 1, 1, 1, 2]
----------------
[0, 0, 1, 1, 2]
[0, 1, 1, 2, 2]
----------------
[0, 0, 0, 1, 2]
[0, 1, 2, 2, 2]
----------------

We can not use dp because we have to print all the paths and all are unique paths. Its a simple backtracking problem
 */
public class RatInMaze3 {

	public static void main(String[] args) {
		printPaths(0, 0, 3, 3, new ArrayList<Integer>(), new ArrayList<Integer>());

	}

	private static void printPaths(int i, int j, int m, int n, ArrayList<Integer> x, ArrayList<Integer> y) {
		if(i==m-1 && j==n-1) {
			//Add last cell, print it and remove
			x.add(i);
			y.add(j);
			System.out.println(x);
			System.out.println(y);
			x.remove(x.size()-1);
			y.remove(y.size()-1);
			System.out.println("----------------");
			return;
		}
		
		if(i>=m || j>=n)
			return;
		
		x.add(i);
		y.add(j);
		printPaths(i+1,j,m,n,x,y);
		printPaths(i,j+1,m,n,x,y);
		x.remove(x.size()-1);
		y.remove(y.size()-1);

	}

}
