package com.scaler.dsa.matrix;

import java.util.Arrays;

/*
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return 
the generated square matrix.

Problem Constraints
1 <= A <= 1000
Input Format
First and only argument is integer A
Output Format
Return a 2-D matrix which consists of the elements added in spiral order.

Input 1:1
Input 2:2
Input 3:5

Output 1:[ [1] ]
Output 2:[ [1, 2], [4, 3] ]
Output 2:[ [1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]

Explanation 1:
Only 1 is to be arranged.

Explanation 2:
1 --> 2
      |
      |
4<--- 3

Approach:
Take 4 variables top, bottom, left and right. left will move up and right will move down. Similarly top will move towards right
and bottom will move towards left
 */
public class SpiralOrderMatrixGeneration {

	public static void main(String[] args) {
		int A = 5;
		int res[][] = generateMatrix(A);
		for (int i = 0; i < res[0].length; i++)
			System.out.println(Arrays.toString(res[i]));

	}

	public static int[][] generateMatrix(int n) {

		int A[][] = new int[n][n];
		int top = 0, left = 0, right = n - 1, bottom = n - 1, count = 1;

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				A[top][i] = count;
				count++;
			}
			top++;
			for (int i = top; i <= right; i++) {
				A[i][right] = count;
				count++;
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					A[bottom][i] = count;
					count++;
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					A[i][left] = count;
					count++;
				}
				left++;
			}
		}
		return A;
	}

}
