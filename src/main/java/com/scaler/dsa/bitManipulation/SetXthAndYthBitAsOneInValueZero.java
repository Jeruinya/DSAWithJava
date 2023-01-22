package com.scaler.dsa.bitManipulation;

/*
 You are given x and y values and you have to set as 1 for these values in the given 8 bit 16 bits of 64 
 bits where all the bits are initially zero.
 */
public class SetXthAndYthBitAsOneInValueZero {

	public static void main(String[] args) {
		int x = 3, y = 1;
		System.out.println(solve(x, y));

		// now dont use if-else/ternary operator and switch case and tell the answer
		System.out.println(solve1(x, y));
	}

	private static int solve1(int x, int y) {
		int res = 0;
		res = (1 << x) | (1 << y);
		return res;
	}

	private static int solve(int x, int y) {
		int res = 0;
		if (x == y)
			res = 1 << x;
		else
			res = (1 << x) + (1 << y);

		return res;
	}
}
