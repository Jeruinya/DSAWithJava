package com.scaler.dsa.bitManipulation;

/*
 You are given x and y values and you have to set as 1 for these values in the given 8 bit 16 bits of 64 bits where all the bits are initially zero.
 */
public class SetXthAndYthBitAsOneInValueZero {

	public static void main(String[] args) {
		int x = 3, y = 1;
		if (x == y)
			System.out.println(1 << x);
		else
			System.out.println((1 << x) + (1 << y));
		
		//now dont use if-else/ternary operator and switch case and tell the answer
			System.out.println((1<<x)|(1<<y));
	}

}
