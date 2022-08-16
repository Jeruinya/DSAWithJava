package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Problem Description
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, 
find the difference between the largest and smallest numbers in that subsequence. 
Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).
NOTE: Subsequence can be non-contiguous.
Problem Constraints
1 <= N <= 10000
1<= A[i] <=1000

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the output.

Input 1:A = [1, 2] 
Input 2:A = [1]

Output 1: 1 
Output 2: 0

Explanation 1:

All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1 
Explanation 2:

 Only 1 subsequence of 1 element is formed.
 
A=[1,3,2] find the sum of the difference of the largest and smallest in all the subsequences.

[1]		=0
[2]		=0
[3]		=0
[1,2]	=1
[1,3]	=2
[[2,3]	=1
[1,2,3]	=2

Ans=0+0+0+1+2+1+2=6

Observation:
Order does not matter so first sort the array.
A=[1,2,3,4]

1-------4   2^2 ways
(1,4)=3
(1,2,4) =3
(1,3,4)=3
(1,2,3,4)=3

1------3     2^1 ways
(1,2,3) =2
(1,3)	=2


[a,b,c,d]
2^0(b-a) + 2^0(c-b)+ 2^0(d-c)+ 2^1(c-a)+2^1(d-b)+2^2(d-a)
=> 2^0(b-a+c-b+d-c)+ 2^1(c-a+d-b) +2^2(d-a)

After solving this we will get below:
(2^3d+2^2c+2^1b+2^0a)-(2^3a+2^2b+2^1c+2^0d)

 */
public class SumTheDifferenceOfSubsequence {

	public static void main(String[] args) {
		int A[] = { 1, 3, 2, 4 };
		System.out.println(findSumDifferencesNaive(A));
	}

	private static int findSumDifferencesNaive(int[] A) {
		Arrays.sort(A);
		int mod = 1000000007;
		long min = 0;
		long max = 0;
		long ans = 0;
		int n = A.length;

		for (int i = 0; i < n; i++) {
			min = (min + A[i] * pow(2, n - i - 1, mod)) % mod;
			min = min % mod;
		}

		for (int i = n - 1; i >= 0; i--) {
			max = (max + A[i] * pow(2, i, mod)) % mod;
			max = max % mod;
		}

		ans = (max - min + mod) % mod;

		return (int) ans;
	}

	public static long pow(long x, int y, int k) {
		long result = 1;
		while (y > 0) {
			if (y % 2 == 1) {
				result = (result * x) % k;
				y--;
			}
			y >>= 1;
			x = (x * x) % k;
		}
		return result;
	}
}