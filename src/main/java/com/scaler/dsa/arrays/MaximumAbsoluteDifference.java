package com.scaler.dsa.arrays;

/*
Problem Description
You are given an array of N integers, A1, A2, .... AN.
Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

Problem Constraints
1 <= N <= 100000
-109 <= A[i] <= 109
Input Format
First argument is an integer array A of size N.
Output Format
Return an integer denoting the maximum value of f(i, j).

Input 1:A = [1, 3, -1]
Input 2:A = [2]

Output 1:5
Output 2:0
Explanation 1:

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
Explanation 2:

Only possibility is i = 1 and j = 1. That gives answer = 0.
 */

/*
|a[i]-a[j]| + |i-j|

case 1: when a[i]>a[j] && i>j
    a[i]-a[j]+i-j
    (a[i]+i) - (a[j]+j) - Equation 1;

case 2: when a[i]<a[j] && i<j
    a[j]-a[i]+j-i
    -a[i]-i+a[j]+j
    -(a[i]+i) + (a[j]+j) - Equation 2

case 3: when a[i]>a[j] && i<j
    a[i]-a[j]+j-i
    a[i]-i-a[j]+j
    (a[i]-i)-(a[j]-j) - Equation 3

case 4: when a[i]<a[j] && i>j
    a[j]-a[i]+i-j
    (a[j]-j)-(a[i]-i) - Equation 4

Equation 1 and 2 are equivalent
Equation 3 and 4 are equivalent

We find diff b/w max of ((a[i]+i)) and min of ((a[i]+i)) - Equation 5
We find diff b/w max of ((a[i]-i)) and min of ((a[i]-i)) - Equation 6

return the max of 5 and 6

*/

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {

		int[] A = { 1, 3, -1 };
		int res = maxAbsoluteDifferenceNaive(A);
		System.out.println(res);

		int res1 = maxAbsoluteDifferenceEfficient(A);
		System.out.println(res1);

	}

	private static int maxAbsoluteDifferenceNaive(int[] A) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				int sum = Math.abs(A[i] - A[j]) + Math.abs(i - j);
				maxValue = Math.max(maxValue, sum);
			}
		}
		return maxValue;
	}

	private static int maxAbsoluteDifferenceEfficient(int[] A) {
		int ans = 0, n = A.length;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			max1 = Math.max(max1, A[i] + i);
			max2 = Math.max(max2, A[i] - i);
			min1 = Math.min(min1, A[i] + i);
			min2 = Math.min(min2, A[i] - i);
		}

		ans = Math.max(ans, max2 - min2);
		ans = Math.max(ans, max1 - min1);
		return ans;
	}
}
