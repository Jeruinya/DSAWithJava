package com.scaler.dsa.maths;

/*
Problem Description
A lucky number is a number that has exactly 2 distinct prime divisors.
You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

Problem Constraints
1 <= A <= 50000
Input Format
The first and only argument is an integer A.
Output Format
Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.

Input 1: A = 8
Input 2: A = 12

Output 1: 1
Output 2: 3

Explanation 1:
 Between [1, 8] there is only 1 lucky number i.e 6.
 6 has 2 distinct prime factors i.e 2 and 3.
Explanation 2:

 Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class LuckyNumbers {

	public static void main(String[] args) {
		int n = 12;
		int count = getLuckCountNaive(n);
		System.out.println(count);
		int count1 = getLuckCountEfficient(n);
		System.out.println(count1);

	}


	private static int getLuckCountEfficient(int n) {
		int isPrime[] = new int[n + 1];
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime[i] == 0) {
				for (int j = i; j <= n; j = j + i)
					isPrime[j]++;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (isPrime[i] == 2)
				ans++;
		}
		return ans;
	}

	// TC-O(N^2 Root n)
	private static int getLuckCountNaive(int n) {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if (isPrime(j) && i % j == 0)
					count++;
			}
			if (count == 2)
				ans++;
		}
		return ans;
	}

	public static boolean isPrime(int a) {
		if (a == 1)
			return false;
		for (int i = 2; i * i <= a; i++) {
			if (a % i == 0)
				return false;
		}
		return true;
	}
}
