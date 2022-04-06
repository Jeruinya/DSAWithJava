package com.scaler.arrays;

/**
 * Given integer array of N elements count member of elements having atleast I
 * number greater than itself {-2,-3,6, 8,4,8,5} Ans is--5
 **/

public class CountNumOfElementsHavingGreaterThanItself {

	public static void main(String[] args) {
		int arr[] = { -2, -3, 6, 8, 4, 8, 5 };
		// find max element
		// count max element
		// return n-count
		int largest = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > arr[largest])
				largest = i;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == arr[largest])
				count++;

		System.out.println(arr.length - count);

	}

}
