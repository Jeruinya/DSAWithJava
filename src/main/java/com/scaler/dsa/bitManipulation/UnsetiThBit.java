package com.scaler.dsa.bitManipulation;

/*
Given n and i, unset the ith bit in n.

To unset one bit we take and with 0 i.e 1&0 0r 0&1=0
Now u want the ith bit to be zero and rest of the bits remains same.
The number you take and with ith bit -->0  and rest-->1

1 1 1 1 0 1 1 1 1
        ith
NOT(0 0 0 0 1 0 0 0)

NOT(1<<i)

 */

public class UnsetiThBit {

	public static void main(String[] args) {
		int n=23;
		int i=1;
		System.out.println(n& (~(1<<i)));

	}

}
