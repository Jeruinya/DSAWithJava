package com.scaler.dsa.java.hashing;

import java.util.HashSet;

/*
Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) 
for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) 
and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.

Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the number of unordered quadruplets that form a rectangle.

Input 1:
 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 1:
 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]

Output 1: 1
Output 2: 3

Explanation 1:
 All four given points make a rectangle. So, the answer is 1.

Explanation 2:
 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2)

Suppose we have two points given that is p1 and p2 then we can find other two points that is p3 and p4.

		p1(x1,y1)			p3(x2,y1)
		
		
		
		p4(x1,y2)			p2(x2,y2)

for every points of p1 and p2 look if there exist points p3 and p4. if yes then count=count+1.

if(x1,y2 and  x2,y1) both contains in the hashSet then it can form rectangle and will do count++.


 */
public class CountRectangles {

	public static void main(String[] args) {
		int A[] = { 1, 1, 2, 2, 3, 3 };
		int B[] = { 1, 2, 1, 2, 1, 2 };
		System.out.println(countRectangles(A, B));
	}

	public static int countRectangles(int[] A, int[] B) {

		int count = 0;
		int n = A.length;
		HashSet<String> hs = new HashSet<>();

		for (int i = 0; i < n; i++)
			hs.add(A[i] + "," + B[i]);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int x1 = A[i];
				int y1 = B[i];
				int x2 = A[j];
				int y2 = B[j];
				if (x1 == x2 || y1 == y2)
					continue;
				if (hs.contains(A[i] + "," + B[j]) && hs.contains(A[j] + "," + B[i]))
					count++;
			}
		}
		return count / 2;
	}
}
