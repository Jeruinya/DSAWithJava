package com.scaler.dsa.recursion;

/*
This program is very important to understand the call stack. 
 */
public class FindOutput {

	public static void main(String[] args) {
		System.out.println(foo(3, 5));

	}

	private static int foo(int x, int y) {
		if (y == 0)
			return 1;

		return bar(x, foo(x, y - 1));
	}

	private static int bar(int x, int y) {
		if (y == 0)
			return 0;
		return x + bar(x, y - 1);
	}

}
