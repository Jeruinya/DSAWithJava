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
