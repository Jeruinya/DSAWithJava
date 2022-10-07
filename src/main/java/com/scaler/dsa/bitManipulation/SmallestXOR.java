package com.scaler.dsa.bitManipulation;

/*
Problem Description
Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.

Problem Constraints
0 <= A <= 109
0 <= B <= 30
Input Format
First argument contains a single integer A. Second argument contains a single integer B.
Output Format
Return a single integer X.

Input 1:
 A = 3
 B = 3
Input 2:
 A = 15
 B = 2

Output 1: 7
Output 2: 12
Explanation 1:

 3 xor 7 = 4 which is minimum

Explanation 2:
 15 xor 12 = 3 which is minimum
 
example:
A=15  B=3

3^7=4 which is minimum.
Ans=7 

Intution:
1-Setting most significant bit of an integer increases the value of the integer more than setting the least significant bit.
2-

1	1	0
0	0	0
1	0	1
0	1	1
So we will try the ith bit of X same as ith bit of A.

3-To balance the number of setbits in X, we will change least significant bit, so that the output remains as small as possible.

Approach :

Case 1: when B<Number of setbits in X
A=27 B=2
X=A
A= 0	1	1	0	1	1
X= 0	1	1	0	1	1

Xsetbit-B=2

A= 0	1	1	0	1	1
X= 0	1	1	0	0	0
...........................
   0	0	0	0	1	1=3  which is minimum possible  so ans is 24

Case 2: when B>Number of setbits in X
A=27 B=5
X=A
A= 0	1	1	0	1	1
X= 0	1	1	0	1	1


A= 0	1	1	0	1	1
X= 0	1	1	1	1	1  
--------------------------
   0	0	0	1	0	0= 4
So answer is 31

There will be three cases
           1) When Set Bits in A == B
              A^A = 0 -> o/p = A
           2) When Set Bits in A > B
              Unset (Set Bits of A - B) set bits of A from RHS
           3) When Set Bits in A < B
              Set (B - Set Bits of A) unset bits of A from RHS 

 */
public class SmallestXOR {

	public static void main(String[] args) {
		System.out.println(findSmallestXor(27, 5));

	}

	public static int findSmallestXor(int A, int B) {
		int x = 0;
		for (int i = 30; i >= 0; i--) {
			if (B == 0)
				return x;
			if (((1 << i) & A) > 0) {
				x |= (1 << i);
				B--;
			}
		}

		for (int i = 0; i <= 30; i++) {
			if (B == 0)
				return x;
			if (((1 << i) & x) == 0) {
				x |= (1 << i);
				B--;
			}
		}
		return x;
	}
}
