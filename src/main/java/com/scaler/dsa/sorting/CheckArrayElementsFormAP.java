package com.scaler.dsa.sorting;

import java.util.Arrays;
/*
Problem Description
Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Input Format
The first and only argument is an integer array A of size N.
Output Format
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0

 */
public class CheckArrayElementsFormAP {

	public static void main(String[] args) {

		int A[] = { 3, 5, 1 };
		Arrays.sort(A);

		for (int i = 0; i < A.length-2; i++) {
			if (A[i] - A[i + 1] != A[i + 1] - A[i + 2]) {
				System.out.println(0);
				break;
			}
		}

		System.out.println(1);

	}

}
