package com.scaler.dsa.bitManipulation;
/*
 Given an integer n and needs to set the ith bit.
eg-n=23, i=3;
n=23= 1 0 1 1 1
i=3=  0 1 0 0 0
OR=   ----------
	  1 1 1 1 1 =31

 */
public class SetiThBit {

	public static void main(String[] args) {
		int n=23, i=3;
		System.out.println(n| (1<<i));
	}

}
