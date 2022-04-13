package com.scaler.dsa.matrix;

import java.util.Arrays;

public class SpriralMatrixGeneration {

	public static void main(String[] args) {
		
		int n=3;
		int top = 0, left = 0, right = n-1, bottom = n - 1;	
		int count =1;
		int arr[][]=new int [3][3];

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				arr[top][i]=count;
				count++;
			}
			top++;
			for (int i = top; i <= right; i++) {
				arr[i][right]=count;
				count++;
			}
			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					arr[bottom][i]=count;
							count++;
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i>= top; i--) {
					arr[i][left]=count;
					count++;
				}
				left++;
			}
		}
		
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(arr[i]));
	}

}