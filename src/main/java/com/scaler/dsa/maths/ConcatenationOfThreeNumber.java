package com.scaler.dsa.maths;

/*
Problem Description
Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
Return the minimum result obtained.

Input 1: A = 10  B = 20  C = 30
Input 2: A = 55  B = 43  C = 47 
 Output 1: 102030 
Output 2: 434755
 */
public class ConcatenationOfThreeNumber {

	public static void main(String[] args) {
		int A = 10, B = 20, C = 30;

		String res = "";
		int min = 0;
		int max = 0;
		int mid = 0;

		if (A >= B && A >= C)
			max = A;
		else if (B >= A && B >= C)
			max = B;
		else if (C >= A && C >= B)
			max = C;

		if (A <= B && A <= C)
			min = A;
		else if (B <= A && B <= C)
			min = B;
		else if (C <= A && C <= B)
			min = C;

		if ((A >= B && A <= C) || (A >= C && A <= B))
			mid = A;

		else if ((B >= A && B <= C) || (B >= C && B <= A))
			mid = B;
		else if ((C >= A && C <= B) || (C >= B && C <= A))
			mid = C;

		res = res + min + mid + max;

		System.out.println(Integer.parseInt(res));

	}

}
