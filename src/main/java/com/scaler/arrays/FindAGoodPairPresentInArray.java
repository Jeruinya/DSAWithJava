package com.scaler.arrays;

/**
 * Problem Description 
 * Given an array A and an integer B. A pair(i, j) in the array is a good pair
 * if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
 */

public class FindAGoodPairPresentInArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 32, 4, 56, 73, 10, 23, 10 };
		int k = 36;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[i] + arr[j] == k && i != j)
					flag = true;
		if (flag == true)
			System.out.println("A good pair of i and j is present in the array");
		else
			System.out.println("A good pair of i and j is not present in the array");
	}
}
