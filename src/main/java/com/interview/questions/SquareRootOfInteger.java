package com.interview.questions;

/*
Problem Description
Given an integer A.

Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.
NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.


Problem Constraints
0 <= A <= 1010
Input Format
The first and only argument given is the integer A.

Output Format
Return floor(sqrt(A))

Input 1: 11
Input 2: 9

Output 1: 3
Output 2: 3

Explanation:
 When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 When A = 9 which is a perfect square of 3, so we return 3.
 */
public class SquareRootOfInteger {

	public static void main(String[] args) {
		float res = squareRoot(10, 4);
		System.out.println(res);

	}

	private static float squareRoot(int n, int p) {
		long s = 0;
		long e = n;
		double ans = 0;

		while (s <= e) {
			long mid = (s + e) / 2;

			if (mid * mid > n)
				e = mid - 1;
			else {
				ans = mid;
				s = mid + 1;
			}
		}
		double increment = 0.1;
		for (int i = 0; i < p; i++) {
			while (ans * ans <=n) {
				ans += increment;
			}
			// loop terminates when ans * ans > number
			ans = ans - increment;
			increment = increment / 10;
		}

		return (float)ans;
	}
}
