package com.scaler.dsa.maths;

import java.util.Arrays;
import java.util.HashSet;

/*
There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

Food for thought :
Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.
Example:
Input:[3 1 2 5 3] 
Output:[3, 4] 
A = 3, B = 4

1+2+3+y+y+.........N--->Sum of arrays, y is the repeating element
1+2+3+4+x+y+.......N--->Sum of n natural numbers.
sum of natural numbers - sum of arrays===> x-y=A------(1)

1^2+2^2+3^2+x^2+y^2+......N^2 -	1^2+2^2+3^2+y^2+y^2+......N^2====>x^2-y^2==>(x+y)(x-y)=B

(x+y)(x-y)=B==>(x+y)*A=B==>x+y=B/A-----(2) eqn1

from equation 1 and 2:
x+y+x-y=A+B/A
2x=A+B/A
x=(A+B/A)/2-------put value of x into any equation to find the value of y.

y=B/2A-A/2



 */
public class FindRepeatedAndMissingNumberInArray {

	public static void main(String[] args) {
		int A[] = { 3, 1, 2, 5, 3 };

		System.out.println(Arrays.toString(findMisAndRepeatingNum(A)));

		System.out.println(Arrays.toString(findMisAndRepeatingNumMap(A)));

		System.out.println(Arrays.toString(findMisAndRepeatingNumEfficient(A)));

	}

	// TC-O(N) SC-O(1)
	private static int[] findMisAndRepeatingNumEfficient(int[] A) {
		long alpha = 0;
		long beta = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			alpha = alpha + (i + 1);
			alpha = alpha - A[i];

			long temp = (i + 1);
			beta = beta + temp * temp;
			long temp1 = A[i];
			beta = beta - temp1 * temp1;
		}
		long x = (alpha + beta / alpha) / 2;
		long y = (beta / alpha - alpha) / 2;

		int res[] = new int[2];
		res[0] = (int) y;
		res[1] = (int) x;

		return res;
	}

	// TC-O(N) SC-O(N)
	private static int[] findMisAndRepeatingNumMap(int[] A) {
		HashSet<Integer> hs = new HashSet<>();
		int rep = 0, mis = 0;
		for (int i = 0; i < A.length; i++) {
			if (hs.contains(A[i]))
				rep = A[i];
			else
				hs.add(A[i]);
		}

		for (int i = 1; i <= A.length; i++) {
			if (!hs.contains(i))
				mis = i;
		}
		int res[] = new int[2];
		res[0] = rep;
		res[1] = mis;

		return res;
	}

	// TC-O(nLogN) SC-O(1)
	private static int[] findMisAndRepeatingNum(int[] A) {
		int n = A.length;
		int rep = -1;
		int sum = 0;
		Arrays.sort(A);
		sum = A[n - 1];
		for (int i = 0; i < n - 1; i++) {
			if (A[i] == A[i + 1]) {
				rep = A[i];
			}
			sum = sum + A[i];
		}
		int miss = (int) ((1L * n * (1L * n + 1)) / 2 - sum + rep);
		int res[] = new int[2];
		res[0] = rep;
		res[1] = miss;
		return res;
	}

}
