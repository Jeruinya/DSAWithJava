package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/*
You are given N positive integers.
For each given integer A, you have to tell whether it is a perfect number or not.
A perfect number is a positive integer which is equal to the sum of its proper positive divisors.


Problem Constraints
1 <= N <= 10
1 <= A <= 106

Input Format
The first line of the input contains a single integer N.
Each of the next N lines contains a single integer A.

Output Format
In a separate line, print YES if a given integer is perfect, else print NO.

Input 1:
 2
 4
 6 
Input 2:
 1
 3 

Output 1:

 NO
 YES 
Output 2:

 NO 


Explanation 1:

 For A = 4, the answer is "NO" as sum of its proper divisors = 1 + 2 = 3, is not equal to 4. 
 For A = 6, the answer is "YES" as sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6. 
Explanation 2:

 For A = 3, the answer is "NO" as sum of its proper divisors = 1, is not equal to 3.
 
A perfect number is a positive integer that is equal to the sum of its positive divisors2, 
excluding the number itself. For instance, 6 has divisors 1, 2 and 3, and 1 + 2 + 3 = 6, so 6 is a perfect

eg--6	28	496		8128		33550336  etc..
 */
public class CheckANumberIsPerfectNumber {

	public static void main(String[] args) {
		System.out.println(isPerfectNumber(28));
		System.out.println(isPerfectNumberEff(28));

	}

	private static String isPerfectNumberEff(int a) {
		int sum = 1;
		for (int j = 2; j * j <= a; j++) {
			if (a % j == 0) {
				if (j * j == a)
					sum = sum + j;
				else
					sum = sum + j + a / j;
			}
		}

		return sum == a ? "YES" : "NO";
	}

	// TC-O(n)
	private static String isPerfectNumber(int n) {
		int sum = 1;
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				sum = sum + i;
		return sum == n ? "YES" : "NO";
	}

}