package com.scaler.arrays;

public class CheckIfArrayIsSorted {

	public static void main(String[] args) {
		int arr[] = { 10, 2, 12, 32, 1, 40 };
		boolean flag = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				flag = false;
				break;
			}
		}
		if(flag==true)
			System.out.println("Array is sorted");
		else
				System.out.println("Array is not sorted");
	}
}
