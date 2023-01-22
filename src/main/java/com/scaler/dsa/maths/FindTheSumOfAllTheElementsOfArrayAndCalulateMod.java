package com.scaler.dsa.maths;
/*
Find the sum of all the elements of the array and then calculate the mod on sum.
so if number is small and able to fit any present data type then its fine but 
if sum is coming as a very big number which can not be stored in any datatype then 
we have to use the modulo formula of sum of a+b;

(a+b)%m= ((a%m + b%m)%m

10^9 --> it is very close to maximum value of integer.
10^9+7 --> its also very close to maximum value of integer and its prime number 

This will be helpful to find the multiplicative inverse

 */

public class FindTheSumOfAllTheElementsOfArrayAndCalulateMod {

	public static void main(String[] args) {
		int A[]= {1,2,10,40,22,3};

		int mod = 5;
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			res = (res + A[i]) % mod;
		}
		System.out.println(res%mod);
	}
}
