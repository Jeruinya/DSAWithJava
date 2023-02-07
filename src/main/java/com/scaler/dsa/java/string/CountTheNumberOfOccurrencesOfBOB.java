package com.scaler.dsa.java.string;
/*
Problem Description
Find the number of occurrences of bob in string A consisting of lowercase English alphabets.

Problem Constraints
1 <= |A| <= 1000

Input Format
The first and only argument contains the string A, consisting of lowercase English alphabets.

Output Format
Return an integer containing the answer.

Input 1:  "abobc"
Input 2:  "bobob"

Output 1:  1
Output 2:  2

Explanation 1:
  The only occurrence is at second position.

Explanation 2:
  Bob occurrence  at first and third position.
 */
public class CountTheNumberOfOccurrencesOfBOB {

	public static void main(String[] args) {
		String A = "bobobo";
		int n = A.length();
		int count = 0;
		int start=0;
		while (start <=n-3) {
			if(A.charAt(start)=='b' && A.charAt(start+1)=='o' && A.charAt(start+2)=='b')
				 count++;
			start++;
		}
		System.out.println(count);

	}

}
