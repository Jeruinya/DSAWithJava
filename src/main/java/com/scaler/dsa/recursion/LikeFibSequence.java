package com.scaler.dsa.recursion;
/*
Problem Description
Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
Given f(0)=1; f(1)=1; f(2)=2;

Problem Constraints
0<=n<=20
Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the Ath term of the sequence.

Input 1: 3
Input 2: 2
Output 1: 7
Output 2: 2

Explanation 1:
 f(3) = 2+1+1+3 = 7
Explanation 2:

 f(2) = 2 as given.
 */
public class LikeFibSequence {

	public static void main(String[] args) {
		int A=3;
		System.out.println(nthTerm(A));
	}
	
	public static int nthTerm(int A){

        if(A==0)
			return 1;
		else if (A== 1)
			return 1;
		else if(A==2)
			return 2;
        return nthTerm(A-1) + nthTerm(A-2)+nthTerm(A-3)+A;
    
    }

}
