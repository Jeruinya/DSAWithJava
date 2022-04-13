package com.scaler.dsa.beginner.basic;

// print [1,2,3,4,5,5,6]
// 1
// 23
// 455
// 6

public class MockProgram1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 5, 6 };
		int k = 0;
		for (int i = 0; i < arr.length;) {
			for (int j = 0; j <= k; j++) {
				System.out.print(arr[i]);
				i++;
			}
			k++;
			System.out.println();
		}
	}

}
