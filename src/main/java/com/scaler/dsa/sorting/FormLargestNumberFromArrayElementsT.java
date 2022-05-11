package com.scaler.dsa.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		int n = A.length;

		String ans = "";
		List<String> temp = new ArrayList<>();

		for (int i : A)
			temp.add(String.valueOf(i));

		Collections.sort(temp, new Mycomp());

		for (String t : temp)
			ans = ans + t;

		System.out.println(ans.charAt(0) == '0' ? "0" : ans.toString());

	}
}

class Mycomp implements Comparator<String> {
	public int compare(String a, String b) {
		return (b + a).compareTo(a + b);
	}
}
