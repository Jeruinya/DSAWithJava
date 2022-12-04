package com.scaler.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateBooleanString {

	public static void main(String[] args) {
		// write your code here
		int n = 2;
		ArrayList<Integer[]> arrlist = new ArrayList<>();
		Integer[] output = new Integer[n];
		generateBooleanStrings(n, 0, output, arrlist);
		for (Integer[] arr : arrlist)
			System.out.print(Arrays.toString(arr));
	}

	public static void generateBooleanStrings(int n, int i, Integer output[], ArrayList<Integer[]> arrayList) {
		// base case
		if (i == n) {
			arrayList.add(output.clone());
			System.out.println(Arrays.toString(output));
			return;
		}
		// rec case
		output[i] = 0;
		generateBooleanStrings(n, i + 1, output, arrayList);
		output[i] = 1;
		generateBooleanStrings(n, i + 1, output, arrayList);
		// output[i] = 6;
		 //generateBooleanStrings(n, i + 1, output, arrayList);
	}

}