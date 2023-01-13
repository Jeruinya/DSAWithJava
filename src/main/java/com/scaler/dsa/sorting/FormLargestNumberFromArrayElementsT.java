package com.scaler.dsa.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

Input Format
The first argument is an array of integers.
Output Format
Return a string representing the largest number.
Input 1: A = [3, 30, 34, 5, 9]
Input 2: A = [2, 3, 9, 0]
Output 1: "9534330"
Output 2: "9320"

Explanation 1:
Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:
Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

 */
public class FormLargestNumberFromArrayElementsT {

	public static void main(String[] args) {
		int A[] = { 3, 30, 34, 5, 9 };

		System.out.println(formLargestNum(A));
	}

	private static String formLargestNum(int[] A) {
		String ans = "";
		List<String> temp = new ArrayList<>();

		for (int i : A)
			temp.add(String.valueOf(i));

		temp = temp.stream().sorted((e1, e2) -> (e2 + e1).compareTo(e1 + e2)).collect(Collectors.toList());

		for (String t : temp)
			ans = ans + t;

		return ans;
	}
}