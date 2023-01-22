package com.scaler.dsa.bitManipulation;

/*
Problem Description
Given a positive integer A, the task is to count the total number of set bits in the binary representation 
of all the numbers from 1 to A.

Return the count modulo 109 + 7.

Problem Constraints
1 <= A <= 109
Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of 
all the numbers from 1 to A )modulo 109 + 7.

Input 1: A = 3
Input 2: A = 1

Output 1: 4
Output 2: 1

Explanation 1:

 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4
Explanation 2:

 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1
 */
public class CountAllSetBitsFrom1ToA {

	public static void main(String[] args) {
		System.out.println(countSetBits(3));
		System.out.println(countAllTheSetbits(3));

	}

	public static int countSetBits(int A) {
		int count = 0;
		for (int i = 1; i <= A; i++)
			count = count + countNumberOfSetBitsEfficient(i);

		return count;
	}

	private static int countNumberOfSetBitsEfficient(int n) {
		int c = 0;
		while (n > 0) {
			if ((n & 1) == 1)
				c++;
			n = n / 2;
		}
		return c;
	}
	
	public  static int countAllTheSetbits(int A) {
        long N = A + 1, mod = 1000*1000*1000 + 7;
        long ans = 0, pow = 1;
        for(int i = 0; i < 32; i++) {
            ans += ((N / (pow << 1)) * pow)%mod + Math.max(0, N % (pow << 1) - pow);
            ans %= mod;
            pow <<= 1;
        }
        return (int)ans;
    }
}
