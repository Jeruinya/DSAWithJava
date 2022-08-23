package com.scaler.dsa.binarySearch;

/*
Problem Description
You are given three positive integers, A, B, and C.
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Problem Constraints
1 <= A <= 109
2 <= B, C <= 40000

Input Format
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.
Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Input 1:
 A = 1
 B = 2
 C = 3
Input 2:
 A = 4
 B = 2
 C = 3

Output 1: 2
Output 2: 6

Explanation 1:
 1st magical number is 2.
Explanation 2:
 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 
Between range [1,x] there Ath magical number will be num%B+ num%C -Num/lcm(B,C) 
if we increase the range then  our value k will also increase and it will never decrease hence our function is monotonic.
so we can apply binary search.
s will be min(B,C) and e will be min(B,C)*A.

A=5
B=2
C=100
B*A=10 and we can find the 5Th magical number in the range 2 to 10 only 
 */
public class AthMagicalNumber {

	public static void main(String[] args) {
		System.out.println(AthMagicalNum(5, 2, 3));
	}

	public static int AthMagicalNum(int A, int B, int C) {
		long s = Math.min(B, C);
		long e = ((long) A) * Math.min(B, C);
		int mod = 1000000007;
		long ans = s;
		if (A == 1)
			return (int) s;
		long lcm = ((long) B * C) / (gcd(B, C));

		while (s <= e) {
			long mid = s + (e - s) / 2;
			long countB = mid / B;
			long countC = mid / C;
			long commonFactors = mid / lcm;
			long position = countB + countC - commonFactors;
			if (position >= A) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;

		}
		if (ans < 0)
			ans = ans + mod;
		return (int) (ans % mod);
	}

	public static int gcd(int x, int y) {
		if (x == 0)
			return y;
		return gcd(y % x, x);
	}
}
