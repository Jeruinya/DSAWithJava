package com.scaler.arrays;

public class ReversingArray {

	public static void main(String[] args) {
		int arr[] = { 10, 2, 3, 32, 54, 78, 90, 70, 40 };
		int k = 0;
		int temp[] = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			temp[k] = arr[i];
			k++;
		}
		for (int t : temp)
			System.out.print(t + " ");
	}

}
