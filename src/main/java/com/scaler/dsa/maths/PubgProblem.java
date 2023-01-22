package com.scaler.dsa.maths;
/*
Problem Description
There are N players, each with strength A[i]. when player i attack player j, 
player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, 
it loses the game, and the game continues in the same manner among other players until only 1 survivor remains.

Can you tell the minimum health last surviving person can have?

Problem Constraints
1 <= N <= 100000
1 <= A[i] <= 1000000
Input Format
First and only argument of input contains a single integer array A.
Output Format
Return a single integer denoting minimum health of last person.

Input 1: A = [6, 4]
Input 2: A = [2, 3, 4]
Output 1: 2
Output 2: 1

Explanation 1:
 Given strength array A = [6, 4]
 Second player attack first player, A =  [2, 4]
 First player attack second player twice. [2, 0]
Explanation 2:

 Given strength array A = [2, 3, 4]
 First player attack third player twice. [2, 3, 0]
 First player attack second player. [2, 1, 0]
 Second player attack first player twice. [0, 1, 0]
 
 Observation:
 its always better for a person of weaker strength to attack to the person of greater strength. This is the way that we can
 get the last standing person to have the minimum strength.
 
 Euclide's algorinthm says that gcd(A,B)= gcd(B%A,B)
 
 */
public class PubgProblem {

	public static void main(String[] args) {
		int A[] = {4,6};
		System.out.println(getLowestStrength(A));

	}

	private static int getLowestStrength(int[] A) {
		int gcd=A[0];
		for(int i=1;i<A.length;i++) {
			gcd=getGcd(gcd,A[i]);
		}
		return gcd;
	}

	private static int getGcd(int a, int b) {
		int a1,b1;
		while(a!=0) {
			a1=b%a;
			b1=a;
			a=a1;
			b=b1;
		}
		return b;
	}

}
