package com.scaler.dsa.recursion;

/*
Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).

Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
Given a,n,m	find a^n%m

Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109
 */
public class CalculateModuloOfPower {

	public static void main(String[] args) {
		//int a = (int) Math.pow(10, 5), n = (int) Math.pow(10, 6), m = (int) Math.pow(10, 9);
		int a= 2, n=3, m=3;
		int res = pow(a, n, m);
		System.out.println(res);
	}

	public static int pow(int A, int B, int C) {
		if (A == 0)
			return 0;
		long ans = findRemainder(A, B, C);
		if (ans < 0)
			return (int) (ans + C) % C;
		else
			return (int) ans;
	}

	public static long findRemainder(int a, int n, int m) {
		if (n == 0)
			return 1;

		long p = findRemainder(a, n / 2, m) % m;
		if (n % 2 == 0)
			return (p * p) % m;
		else
			return ((p * p) % m * a % m) % m;
	}
	
	//Iterative and easy way
	public int pow1(int x, int n, int d) {
	    long a = x;
	    long res = 1L;
	    while (n > 0) {
	        if (n % 2 == 1) {
	            res *= a;
	            res %= d;
	        }
	        a *= a;
	        a %= d;
	        n = n >> 1;
	    }
	    res = (res + d) % d;
	    return (int) res;
	}
}
