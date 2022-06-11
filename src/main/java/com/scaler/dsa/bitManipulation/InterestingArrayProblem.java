package com.scaler.dsa.bitManipulation;

/**

Problem Description
You have an array A with N elements. We have two types of operation available on this array :
1-We can split an element B into two elements, C and D, such that B = C + D.
2-We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, 
containing a single element equal to 0 after several splits and/or merge?

Observation 1: if any element in the array is even than it can be made as 0->split 
element into two equal part Ai/2 and Ai/2 and XOR of the two equal elements are zero.
Observation 2: if any element is odd then we can split it into two parts 1 and Ai-1. 
Ai-1 is even that is an odd element can be reduce its size to 1.
Observation 3: two odd elements can be made as zero by following above strategy and finally XOR them.

 */


public class InterestingArrayProblem {

	public static void main(String[] args) {
		int A[] = {10,20,9};
		String res = "";
		int count = 0;
		for (int i = 0; i < A.length; i++)
			if (A[i] % 2 != 0)
				count++;

		if (count % 2 == 0)
			res = "Yes";
		else
			res = "No";

		System.out.println(res);
	}
}
