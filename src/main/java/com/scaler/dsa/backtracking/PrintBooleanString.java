package com.scaler.dsa.backtracking;

import java.util.Arrays;

/*
Print all the boolean string of 0 and 1 of length N.

N=3
[0, 0, 0]
[0, 0, 1]
[0, 1, 0]
[0, 1, 1]
[1, 0, 0]
[1, 0, 1]
[1, 1, 0]
[1, 1, 1]
 */
public class PrintBooleanString {

	public static void main(String[] args) {
		// write your code here
		int n = 4;
		int[] output = new int[n];
		generateBooleanStrings(n, 0, output);
	}

	public static void generateBooleanStrings(int n, int i, int output[]) {
		// base case
		if (i == n) {
			System.out.println(Arrays.toString(output));
			return;
		}
		// rec case
		output[i] = 0;
		generateBooleanStrings(n, i + 1, output);
		output[i] = 1;
		generateBooleanStrings(n, i + 1, output);
	}

}
