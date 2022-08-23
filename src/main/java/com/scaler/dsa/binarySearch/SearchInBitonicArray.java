package com.scaler.dsa.binarySearch;

/*
Problem Description
Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the 
bitonic sequence in O(logN) time.
NOTE:A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Problem Constraints
3 <= N <= 105
1 <= A[i], B <= 108
Given array always contain a bitonic point.
Array A always contain distinct elements.

Input Format
First argument is an integer array A denoting the bitonic sequence.
Second argument is an integer B.

Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if 
B doesn't exist in A return -1.

Input 1: A = [3, 9, 10, 20, 17, 5, 1]  B = 20
Input 2: A = [5, 6, 7, 8, 9, 10, 3, 2, 1]  B = 30

Output 1: 3
Output 2: -1

Explanation 1:
 B = 20 present in A at index 3
Explanation 2:
 B = 30 is not present in A




A simple solution is to do linear search. Time complexity of this solution would be O(N).
An efficient solution is based on Binary Search. The idea is to find the bitonic point k which is 
the index of the maximum element of given sequence. If the element to be searched is greater than 
maximum element return -1, else search the element in both halves. Below is the step by step 
algorithm on how to do this.

Find the bitonic point in the given array, i.e the maximum element in the given bitonic array. 
This can be done in log(N) time by modifying the binary search algorithm. You can refer to this post on how to do this.
If the element to be searched is equal to the element at bitonic point then print the index of bitonic point.
If the element to be searched is greater than element at bitonic point then element does not exist in the array.
If the element to be searched is less than element at bitonic point then search for element in both 
half of the array using binary search.
 */
public class SearchInBitonicArray {

	public static void main(String[] args) {
		int A[] = { 3, 9, 10, 20, 17, 5, 1 };
		int B = 20;
		System.out.println(linearSearch(A, B));

	}

	public static int linearSearch(int[] A, int B) {
		for (int i = 0; i < A.length; i++)
			if (A[i] == B)
				return i;

		return -1;
	}
}
