package com.scaler.dsa.recursion;
/*
This program is very important to understand the call stack. 

 */
public class FindOutput1 {

	public static void main(String[] args) {
		System.out.println(fun(2, 10));

	}

	private static int fun(int x, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0)
			return fun(x * x, n / 2);
		else
			return x * fun(x * x, (n - 1) / 2);
	}

}
