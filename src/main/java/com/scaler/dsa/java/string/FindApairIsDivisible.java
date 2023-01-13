package com.scaler.dsa.java.string;

/*
Given an array of strings, we needs to check if we concatenate two values of array then its divisible by B. here i!=j.
String A[]=[1535,1512,1216,1612]   B=2.
All the combinations which needs to check is --1535+1512  , 1535+1216  , 1535+1612  , 1512+1535 ,  1512+1216  , 1512+1612,
										1216+1535  , 1216+11512   , 1216+1612   1612+1535  , 1612+1512   , 1612+1216 
										
count number of such pairs divisible by B. Here there are 9 pairs which are divisible by B so answer is 9.
 */
public class FindApairIsDivisible {

	public static void main(String[] args) {
		String A[] = { "1535", "1512", "1216", "1612" };
		int B = 2;
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i != j)
					if (isDivisible(A[i] + A[j], B))
						count++;
			}
		}
		System.out.println(count);

	}

	private static boolean isDivisible(String str, int B) {
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			temp = temp * 10 + str.charAt(i) - '0';
			temp = temp % B;
		}
		return temp == 0;
	}

}
