package com.interview.questions;

import java.util.Arrays;

public class Findoutput25 {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 5, 6, 7, 8, 9, 10, 11 };

		System.out.println(Arrays.binarySearch(numbers, 4));

		int[] numbers1 = { 1, 5, 4, 6, 7, 8, 9, 10, 11 };
		System.out.println(Arrays.binarySearch(numbers1, 4));

	}

}
