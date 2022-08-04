package com.scaler.dsa.maths;

/*
Given an array check if there exists a subsequence with GCD 1.

A[]={10,20,12,40,13} there will be 2^n subsequences.

Subsequences:
	{}	{10}	{20}	{12}	{40}	{13}	{10,20}	{10,20,12}	{10,20,12,40}	{10,20,12,40,13}
	{10,12}	{10,12,40}	{10,12,40,13}	{20,12}	{20,12,40}  {20,12,40,13}   {12,40}	{12,40,13} 	etc.

Observation: If the gcd of the array is 1 then there always exists a subsequence whose gcd is one.

{6,12,3,18}--->gcd=3
{16,10,6,15,27}--->gcd=1
 */
public class CheckIfAsubsequenceHaveGCDOne {

	public static void main(String[] args) {
		int A[]={16,10,6,15,27};
		boolean flag=isSubsequenceExistWithGcdOne(A);
		System.out.println(flag);

	}

	private static boolean isSubsequenceExistWithGcdOne(int[] A) {
		int gcd=A[0];
		for(int i=1;i<A.length;i++) {
			gcd=getGcd(A[i],gcd);
			if(gcd==1)
				return true;
		}
		return false;
	}

	private static int getGcd(int a, int b) {
		int a1,b1;
		while(a!=b) {
			a1=b%a;
			b1=a;
			a=a1;
			b=b1;
		}
		return b;
	}

}
