package com.scaler.dsa.arrays;

import java.util.Scanner;

/**
 * Given an array Build leftmax array. leftman[i]= max value in the given array
 * from 0 to i A[]= {-3,6,2,4,5,2,8,-9}
 * 
 */

public class FindLeftMaxForGivenIndexInArray {

	public static void main(String[] args) {

		int A[] = { -3, 6, 2, 4, 5, 2, 8, -9 };
		Scanner s = new Scanner(System.in);
		int n = A.length;
		int leftMax[] = new int[n];
		leftMax[0] = A[0];
		for (int i = 1; i < n; i++) {
			if (A[i] > leftMax[i - 1])
				leftMax[i] = A[i];
			else
				leftMax[i] = leftMax[i - 1];
		}
		int index = s.nextInt();
		if (index < n) {
			//int leftMaxElem = Math.max(leftMax[index - 1], A[index]);
			int leftMaxElem = leftMax[index - 1];
			System.out.println(leftMaxElem);
		} else
			System.out.println("Index is not in the range, please provide a valid range");
	}

}
