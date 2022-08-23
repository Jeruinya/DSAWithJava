package com.scaler.dsa.binarySearch;

/*
Problem Description
Given an array of integers A, find and return the peak element in it. 
An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 109
Input Format
The only argument given is the integer array A.
Output Format
Return the peak element.

Input 1:A = [1, 2, 3, 4, 5]
Input 2:A = [5, 17, 100, 11]
Output 1: 5
Output 2: 100

Explanation 1:
 5 is the peak.
Explanation 2:
 100 is the peak.
 
Naive approach: iterate over array and check if A[i-1]<A[i]>A[i+1] if any element found return.

Optimize Approach:
A[]={40,10,20,5,45,50,65,90,35,25}   Draw these in X and Y coordinates and observe
pick x as random:
1-x can be peak element
2-x cant be peak element.

if x is peak element return x
if x is not peak element then at least one of its neighbor  element is greater than x.
if Left neighbor> X then peak element is in left side of X.
if right neighbor>X then peak element is in right side of X.

Conclusion:
At a non-peak element, move to the left or right half of the array based on the left neighbor or right neighbor.

Based on the condition we can apply binary search on the array to figure out peak element.

Try to think when will the unique answer exists,Unique answer only exists when the elements 
first increases and then decreases.
Check is first or last element is the answer.
 */
public class FindPeakElement {

	public static void main(String[] args) {
		int A[] = { 40, 10, 20, 5, 45, 50, 65, 90, 35, 25 };
		System.out.println(peakElementNaive(A));
		int A1[] = { 1, 2, 3, 4, 5 };
		System.out.println(peakElementEff(A1));
	}

	private static int peakElementEff(int[] A) {
		int n = A.length;
		if (n == 1)
			return A[0];
		if (A[1] <= A[0])
			return A[0];
		if (A[n - 1] >= A[n - 2])
			return A[n - 1];

		int s = 1;
		int e = n - 2;

		while (s <= e) {
			int mid = (e - s) / 2 + s;

			if (A[mid - 1] <= A[mid] && A[mid] >= A[mid + 1])
				return A[mid];
			else if (A[mid - 1] >= A[mid])
				e = mid - 1;
			else
				s = mid + 1;
		}
		return -1;
	}

	private static int peakElementNaive(int[] A) {
		int n = A.length;

		if (n == 1)
			return A[0];

		for (int i = 1; i < n - 1; i++) {
			if (A[i - 1] < A[i] && A[i] > A[i + 1])
				return A[i];
		}

		if (A[0] > A[1])
			return A[0];
		if (A[n - 1] >= A[n - 2])
			return A[n - 1];

		return -1;

	}

}
