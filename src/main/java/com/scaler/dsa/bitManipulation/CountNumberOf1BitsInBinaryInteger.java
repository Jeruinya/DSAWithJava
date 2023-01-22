package com.scaler.dsa.bitManipulation;

/**
 * 
 * Problem Description: Write a function that takes an integer and returns the
 * number of 1 bits it has. Problem Constraints: 1 <= A <= 109 Input Format
 * :First and only argument contains integer A
 * 
 * Output Format: Return an integer as the answer
 * 
 * Input1:11 Output1:3 Example Explanation Explaination1: 11 is represented as
 * 1011 in binary.
 * 
 */

public class CountNumberOf1BitsInBinaryInteger {

	public static void main(String[] args) {
		int A = 29;
		System.out.println(countSetBits(A));

		System.out.println(numSetBits(A));

	}

	public static int countSetBits(int A) {
		int count = 0;
		while (A > 0) {
			int rem = A % 2;
			if (rem == 1)
				count++;
			A = A / 2;
		}
		return count;
	}

	public static int numSetBits(int A) {
		int total_ones = 0;
		while (A != 0) {
			A = A & (A - 1);
			total_ones++;
		}
		return total_ones;
	}
	
	public static int numSetBits1(int A) {

        int count=0;
        while(A>0){
            if((A&1)==1)
                count++;
           A= A>>1;
        }
        return count;       
    }
}
