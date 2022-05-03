package com.scaler.dsa.java.string;

/*
Problem Description
You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.

Input 1: A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm',0,1, 'y']
Input 2: A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']

Output 1: 1
Output 2: 0
 */
public class IsAlphabet {

	public static void main(String[] args) {
		char A[] = { 'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm','0','1', 'y' };
		int flag = 1;
		for (int i = 0; i < A.length; i++) {
			if(!(A[i]>=65 && A[i]<=90|| A[i]>=97 && A[i]<=122 || A[i]>=48 && A[i]<=57)) {
				flag = 0;
				break;
			}
		}
		System.out.println(flag);
	}

}
