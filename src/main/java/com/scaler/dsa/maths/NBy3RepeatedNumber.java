package com.scaler.dsa.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109

Input Format
The only argument is an integer array A.

Output Format
Return an integer.

Example Input
[1 2 3 1 1]

Example Output
1


Example Explanation
1 occurs 3 times which is more than 5/3 times.
 */
public class NBy3RepeatedNumber {

	public static void main(String[] args) {

		int A[] = { 1, 2, 3, 1, 1 };
		ArrayList<Integer> a = new ArrayList<>();

		for (int i = 0; i < A.length; i++)
			a.add(A[i]);
		System.out.println(repeatedNumber(a));
	}

	public static int repeatedNumber(final List<Integer> A) {
		int num;
		int n = A.size();
		Collections.sort(A);
		for (int i = 0; i < n;) {
			int freq = 0;
			num = A.get(i);
			while (i < n && A.get(i) == num) {
				freq++;
				i++;
			}
			if (freq > n / 3)
				return num;
		}
		return -1;
	}
}