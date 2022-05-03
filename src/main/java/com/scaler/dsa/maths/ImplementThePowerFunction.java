package com.scaler.dsa.maths;

/*
implement the power function power(a,n,p)-->a^n%p;
 */
public class ImplementThePowerFunction {

	public static void main(String[] args) {
		long ans = 1;
		int a = 2, n = 7, p = 6;
		for (int i = 0; i < n; i++)
			ans = (ans % p * a % p) % p;
		System.out.println(ans);
	}
}
