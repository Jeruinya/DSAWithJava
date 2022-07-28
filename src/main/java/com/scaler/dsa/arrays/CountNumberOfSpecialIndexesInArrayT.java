package com.scaler.dsa.arrays;

/*
  Q2. Count ways to make sum of odd and even indexed elements equal by removing an array element
  
  Problem Description * 
  Given an array, arr[] of size N, the task is to find the count of array
  indices such that removing an element from these indices makes the sum of
  even-indexed and odd-indexed array elements equal.
  
  Output Format
 Return the count of array indices such that removing an element from these indices makes the sum of even-indexed 
 and odd-indexed array elements equal.
 
 Problem Constraints
1 <= n <= 105
-105 <= A[i] <= 105
Input Format
First argument contains an array A of integers of size N
Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
Input 1:A=[2, 1, 6, 4]
Input 2:A=[1, 1, 1]

Output 1:1
Output 2:3

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 

Explanation 2:
Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.

Observation 1:if i remove ith index, all the indexes <i remains same.
Observation 2: if i remove ith index, all the indexes > i :
	-even indexed element become odd index element
	-odd indexed elements become even indexed elements.

sum of even to the left of i  =pse[i-1]
sum of even indexed elements to the right=sum of all the odd indexed elements to the right i.e pso[n-1]-pso[i]

so sum of all the even indexed elements= pse[i-1]+pso[n-1]-pso[i]

sum of odd indexed to the left = pso[i-1]
sum of odd indexed to the right= pse[n-1]-pse[i]
 
 */

public class CountNumberOfSpecialIndexesInArrayT {

	public static void main(String[] args) {
		int A[] = { 2, 1, 6, 4 };
		int n = A.length;
		int count = countSpecialIndexes(A, n);
		System.out.println(count);
	}

	public static int countSpecialIndexes(int[] A, int n) {

		int pso[] = new int[n];
		int pse[] = new int[n];

		pse[0] = A[0];
		pso[0] = 0;
		for (int i = 1; i < n; i++) {
			if (i % 2 == 0)
				pse[i] = pse[i - 1] + A[i];
			else
				pse[i] = pse[i - 1];
		}

		for (int i = 1; i < n; i++) {
			if (i % 2 != 0)
				pso[i] = pso[i - 1] + A[i];
			else
				pso[i] = pso[i - 1];
		}
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (pse[n - 1] == pso[n - 1])
					count++;
			} else {
				int Se = pse[i - 1] + pso[n - 1] - pso[i];
				int Ro = pso[i - 1] + pse[n - 1] - pse[i];
				if (Se == Ro)
					count++;
			}
		}

		return count;
	}
}
