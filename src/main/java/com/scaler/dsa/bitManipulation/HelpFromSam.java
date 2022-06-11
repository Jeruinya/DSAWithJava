package com.scaler.dsa.bitManipulation;

/*
Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from 
Sam for doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. 
Also, he does not want to take much help from Sam.
Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.


Approach:
1. If odd number, subtract 1 and increment count.
2. Divide number by 2.
3. Repeat step#1 and #2, until the number becomes 0.
4. Return count.
 */

public class HelpFromSam {

	public static void main(String[] args) {
		int n=4,count=0;
		while(n>0) {
			if((n&1)==1) {
				count++;
			}
			n=n>>1;
		}
		System.out.println(count);

	}

}
