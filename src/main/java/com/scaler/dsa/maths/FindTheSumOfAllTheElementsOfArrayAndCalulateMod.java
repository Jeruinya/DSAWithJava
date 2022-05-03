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
		int arr[] = { 1, 2, 3, 5, 6, 87, 98, 1000, 2000000000, 499 };

		int mod = 31;
		int res = 1;
		for (int i = 0; i < arr.length; i++) {
			res = (res + arr[i]) % mod;
		}
		System.out.println(res%mod);
	}
}
