package com.scaler.dsa.recursion;

import java.util.ArrayList;

/*
Problem Description
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
A gray code sequence must begin with 0.

Problem Constraints
1 <= A <= 16
Input Format
The first argument is an integer A.
Output Format
Return an array of integers representing the gray code sequence.

Input 1:A = 2
Input 1:A = 1

output 1:[0, 1, 3, 2]
output 2:[0, 1]

Explanation 1:
for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].
Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].

Grey code of A=2
0 0
0 1
1 1
1 0

Reverse Grey code of A=2
1 0
1 1
0 1
0 0



A=3
0 0 0	-0
0 0 1	-1
0 1 1	-3
0 1 0	-2
1 1 0	-6
1 1 1	-7
1 0 1	-5
1 0 0	-4

Observation: if we write grey code for A=2 then reverse it so we have grey code and reverse grey code.
we can see in that in the first half of A=3 its having grey code of A=2 and in the second half reverse grey code of A=2. 
 */
public class GrayCode {

	public static void main(String[] args) {
		int A=3;
		ArrayList<Integer>list =getGreyCode(A);
		System.out.println(list);
		
	}

	private static ArrayList<Integer> getGreyCode(int A) {
		ArrayList<Integer> list= new ArrayList<>();
		list.add(0);
		for(int i=0;i<A;i++) {
			int currListSize=list.size();
			for(int j=currListSize-1;j>=0;j--) 
				list.add(list.get(j)+ (1<<i));
			
		}
		return list;
	}

}
