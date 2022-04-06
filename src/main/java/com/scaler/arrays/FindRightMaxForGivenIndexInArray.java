package com.scaler.arrays;

import java.util.Scanner;

public class FindRightMaxForGivenIndexInArray {

	public static void main(String[] args) {
		int A[] = { -3, 6, 2, 4, 5, 2, -9 };
		Scanner s = new Scanner(System.in);
		int n = A.length;
		int rightMax[] = new int[n];
		rightMax[n - 1] = A[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (A[i] > rightMax[i + 1])
				rightMax[i] = A[i];
			else
				rightMax[i] = rightMax[i + 1];
		}
		int index = s.nextInt();
		int rightMaxElem = Integer.MIN_VALUE;
		if (index < n) {
			if (index == n - 1) {
				rightMaxElem = A[index];
				System.out.println(rightMaxElem);
			} else {
				//rightMaxElem = Math.max(rightMax[index + 1], A[index]);
				rightMaxElem = rightMax[index-1];
				System.out.println(rightMaxElem);
			}
		} else
			System.out.println("Index is not in the range, please provide a valid range");
	}

}
