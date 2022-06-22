package com.scaler.dsa.maths;
/*
Problem Description
Given an integer A, find and return the Ath magic number.
A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
Input Format
The only argument given is integer A.

Output Format
Return the Ath magic number.

Example Input 1: A = 3
Example Input 2: A = 10----1010---5^4+5^3*0+5^2*1+5^1*0===650

Example Output 1: 30
Example Output 2: 650

 */








public class FindnthMagicNumber {

	public static void main(String[] args) {
		int A=10;
		int x=1, ans=0;
        while(A>0){
            x=x*5;
            if(A%2==1){
                ans=ans+x;
            }
            A=A>>1;
        }
        System.out.println(ans);
    }
}