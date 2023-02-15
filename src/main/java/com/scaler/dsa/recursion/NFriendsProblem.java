package com.scaler.dsa.recursion;

/*
 N friends are going for a party,each friend can go solo or as a couple.Find out to total ways in which they can go.
 
 N=3  A B C
 (AB) C
 (AC) B
 (BC) A
 (A) (B) (C)
 
 so there are total 4 ways that they can go to party
 so total number of ways = Solo+ Couple

 		solo		couple
f(n)= 1*f(n-1)+ 1*(n-1)*f(n-2)

1-Suppose 1 person decided to go solo then there will be n-1 person remaining to make their choices.
2-Suppose 1 person decided to go as couple then he/she has n-1 people to pick as his/her couple and remaining n-2 people can
  make their choice to go either solo or as a couple.
  
Example:
N=4
	A	B	C	D
	1*f(4-1)+ 1*(4-1)*f(4-2)
	1*f(3)+3*f(2)
	4+3*2=10


 */
public class NFriendsProblem {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(totalWays(n));
	}

	private static int totalWays(int n) {
		if (n <= 2)
			return n;
		return totalWays(n - 1) + (n - 1) * totalWays(n - 2);
	}

}
