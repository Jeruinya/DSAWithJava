package com.scaler.dsa.matrix;

/*
Problem Description
Given a 2D integer matrix A of size N x N, find a B x B sub matrix where B<= N and B>= 1, 
such that the sum of all the elements in the sub matrix is maximum.

Problem Constraints
1 <= N <= 103.
1 <= B <= N
-102 <= A[i][j] <= 102.

Input Format
First argument is an 2D integer matrix A.
Second argument is an integer B.

Output Format
Return a single integer denoting the maximum sum of sub matrix of size B x B.

Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:
 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2

Output 1: 48
Output 2: 8

Explanation 1:
    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
    
Explanation 2:
 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8
  
Method 1- Brute Force:
A Simple Solution is to consider all possible sub-squares of size B x B in our input matrix and find the one which has the maximum sum.
Time complexity of above solution is O(N2B2).
This will timeout for the given constraints.

Method 2- Efficient Approach:
The idea is to pre-process the given square matrix. In the preprocessing step, calculate the sum of all vertical strips of size B x 1 in a temporary square matrix stripSum[][].
Once we have the sum of all vertical strips, we can calculate the sum of the first sub-square in a row as the sum of the first B strips in that row, and for the remaining sub-squares, we can calculate the sum in O(1) time by removing the leftmost strip of the previous subsquare and adding the rightmost strip of the new square.
Time complexity of this solution is O(N2).
 */
public class R_MaximumSumSubmatrix {

	public static void main(String[] args) {
		int A[][] = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 8, 6, 7, 3 }, { 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 } };
		int B = 3;
		System.out.println(solve(A, B));

	}

	public static int solve(int[][] A, int B) {
		int[][] ps = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (j == 0) {
					ps[i][j] = A[i][j];
				} else {
					ps[i][j] = ps[i][j - 1] + A[i][j];
				}
			}
		}
		for (int j = 0; j < A.length; j++) {
			for (int i = 0; i < A.length; i++) {
				if (i != 0) {
					ps[i][j] = ps[i][j] + ps[i - 1][j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i + B - 1 < A.length && j + B - 1 < A.length) {
					int sum = ps[i + B - 1][j + B - 1];
					if (j > 0) {
						sum = sum - ps[i + B - 1][j - 1];
					}
					if (i > 0) {
						sum = sum - ps[i - 1][j + B - 1];
					}
					if (i > 0 && j > 0) {
						sum += ps[i - 1][j - 1];
					}
					max = Math.max(sum, max);
				}
			}
		}
		return max;
	}
}
