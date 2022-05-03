package com.scaler.dsa.maths;
/*
Given a number n and find the factorial and then calculate the mod m
suppose number is 20! and mod=47 then find 20!%47;
number is could be very big so we can not find the factorial first and the mod. we can not store 30! in any datatype 
present in java but we have to calculate the modulo of this number. so to do this we have to use the modulo formula 

(a+b)%p===(a%p +b%p)%p
(a*b)%p===(a%p *b%p)%p
(a-b)%p===(a%p +b%p+m)%p
(a/b)%p===(a%p *b^-1%p)%p

suppose we have 5!=(1*2*3*4*5)%m   =(((1*2*3*4)%m*5%m)%m =((1*2*3)%m * 4%m * 5%m)%m  = like this it will be 
(1%m * 2%m * 3%m * 4%m * 5%m)%m 
so that is why used fact=(fact*i)%m
 */

public class CalculateTheModOfFactorialNumber {

	public static void main(String[] args) {
		int n = 40;
		long fact = 1;
		int mod = 23;
		for (int i = 2; i <= n; i++) {
			fact = (fact * i) % mod;
		}
		System.out.println(fact%mod);

	}

}
