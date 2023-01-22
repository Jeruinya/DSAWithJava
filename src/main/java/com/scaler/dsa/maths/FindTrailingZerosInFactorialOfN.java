package com.scaler.dsa.maths;
/*
Given number N, find number of trailing zeros at end in n!.

n=5  n!=120  so there are one zero.

Step 1: compute factorial.
Step 2: divide by 10 and count zeros until its not giving non zero remainder.

The problem with the above approach is , suppose n is very large then will get the overflow.To avoid the the overflow
we can use BigInteger but that will reduce the performance.

Optimization:
The only number which is contributing zero at end is 2 and 5. so we have to count number of 2's and 5's in the number.
As we can see number of 2's always will be greater than 5 so just count the number of 5's in the number n.

n=100
125!	..5..10..15..20..25..30..35..40..45..50..55..60..65..70..75..80..85..90..95..100..105..110..115..120..125

so we have to count the number of numbers which are contributing 1 five, 2 five, 3 five ....n fives.


 */
public class FindTrailingZerosInFactorialOfN {

	public static void main(String[] args) {
		int n=10;
		System.out.println(findTrailingZeros(n));
		
		System.out.println(findTrailingZerosEff(n));

	}

	//TC-O(log5^n)
	private static int findTrailingZerosEff(int n) {
		int count=0;
		for(int i=5;i<=n;i=i*5)
			count=n/i;
		return count;
	}

	//TC-O(n)
	private static int findTrailingZeros(int n) {		
		int fact=factorial(n);
		int count=0;
		while(fact%10==0) {
			count++;
			fact=fact/10;
		}
		return count;
	}

	//TC-O(n)
	private static int factorial(int n) {
		if(n==0 || n==1)
			return 1;
		return n*factorial(n-1);
	}

}
