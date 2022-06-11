package com.scaler.dsa.bitManipulation;

/*
Given  x and y ,Create a number with x set bits and y unset bits

x=3, y=2
Number will be  1 1 1 0 0-->28

rer= (x+y) ones - y ones

	1 1 1 1 1 
	0 0 0 1 1 
	---------
	1 1 1 0 0 -->ans
	
n ones
-------
1 ones=====1======2^1-1
2 ones=====1 1======2^2-1
3 ones=====1 1 1======2^3-1
4 ones=====1 1 1 1======2^4-1
.
.
.
x+y ones=====1111....1===2^x+y-1
y ones =====1111.....1===2^y-1

x+y ones - y ones= 2^x+y-1 -(2^y-1)=2^x+y-2^y==(1<<x+y)-(1<<y)
 */
public class CreateNumberUsingXSetAndYUnsetBits {

	public static void main(String[] args) {
		int x=4, y=2;
		int res=(1<<x+y)- (1<<y);
		System.out.println(res);

	}

}
