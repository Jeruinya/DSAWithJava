package com.scaler.dsa.sorting;

/*
Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the 
same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByColour {

	public static void main(String[] args) {
		int A[] = {0 ,1 ,2, 0, 1, 2};
		List<Integer> temp = new ArrayList<>();

		for (int i : A)
			temp.add(i);

		Collections.sort(temp,new Mycomp1());;
		System.out.println(temp);
	}
}

class Mycomp1 implements Comparator<Integer> {
	@Override
	public int compare(Integer i, Integer j) {
		return i.compareTo(j);
	}

}
