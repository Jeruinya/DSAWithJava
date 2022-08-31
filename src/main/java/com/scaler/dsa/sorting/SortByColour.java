package com.scaler.dsa.sorting;

/*
Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the 
same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.
 */
import java.util.ArrayList;
import java.util.Arrays;

class SortByColour {

	public static void main(String[] args) {
		int A[] = { 0, 1, 2, 0, 1, 2 };
		ArrayList<Integer> temp = new ArrayList<>();

		for (int i : A)
			temp.add(i);

		Arrays.sort(A);
		System.out.println(Arrays.toString(A));//nlogn
		System.out.println(sortColors(temp));

	}

	//TC-)--O(n)
	public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {

		int zero = 0;
		int two = A.size() - 1;

		for (int i = 0; i <= two;) {
			if (A.get(i) == 0) {
				int temp = A.get(zero);
				A.set(zero, 0);
				A.set(i, temp);
				zero++;
				i++;
			} else if (A.get(i) == 2) {
				int temp = A.get(two);
				A.set(two, 2);
				A.set(i, temp);
				two--;
			} else {
				i++;
			}
		}
		return A;
	}

}
