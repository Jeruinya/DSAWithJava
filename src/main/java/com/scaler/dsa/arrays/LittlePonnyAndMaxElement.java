package com.scaler.dsa.arrays;

/*
  Problem Description:
  Little Ponny is given an array, A, of N integers. In a particular operation,
  he can set any element of the array equal to -1.
  He wants your help in finding out the minimum number of operations required
  such that the maximum element of the resulting array is B. If it is not possible, then return -1.
 */

public class LittlePonnyAndMaxElement {

	public static void main(String[] args) {
		int A[] = { 24, 33, 13, 11, 30, 28, 19, 8, 30, 25, 42, 6, 30, 49, 3, 49, 24, 13, 3, 50};
		int B = 13;
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == B) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			for (int i = 0; i < A.length; i++)
				if (A[i] > B)
					count++;

		}

		if (flag == true)
			System.out.println(count);
		else
			System.out.println(-1);
	}
}
