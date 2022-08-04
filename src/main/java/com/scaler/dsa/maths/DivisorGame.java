package com.scaler.dsa.maths;

/*
Problem Description
Scooby has 3 three integers A, B, and C.
Scooby calls a positive integer special if it is divisible by B and it is divisible by C. 
You need to tell the number of special integers less than or equal to A.
Problem Constraints
1 <= A, B, C <= 109
Input Format
First argument is a positive integer A
Second argument is a positive integer B
Third argument is a positive integer C
Output Format
One integer corresponding to the number of special integers less than or equal to A.

Input 1: A = 12  B = 3  C = 2
Input 2: A = 6 B = 1  C = 4
Output 1: 2
Output 2: 1

Explanation 1:
 The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
Explanation 2:
 Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
 */
public class DivisorGame {

	public static void main(String[] args) {
		int A=100;
		int B=2;
		int C=4;
		System.out.println(countAllMultiplesNaive(A,B,C));
		System.out.println(countAllMultiplesEfficient(A,B,C));

	}

	private static int countAllMultiplesNaive(int A, int B, int C) {
		int count=0;
		for(int i=1;i<=A;i++)
			if(i%B==0 && i%C==0)
				count++;
		return count;
	}
	
	public static int countAllMultiplesEfficient(int A, int B, int C) {

        int lcm=(C*B)/(getGcd(C,B));
        int count=0;

        for(int i=lcm;i<=A;i=i+lcm){
            if(i%B==0 && i%C==0)
                count++;
        }
        return count;

    }

    private static int getGcd(int a, int b) {
		int a1, b1;
		while (a != 0) {
			a1 = b % a;
			b1 = a;
			a = a1;
			b = b1;
		}
		return b;
	}

}
