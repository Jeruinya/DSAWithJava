package com.scaler.dsa.recursion;

/*
Given an array, check whether array is sorted or not.

Recursion always occurs with extra space
 */
public class CheckArrayIsSorted {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3,8, 20 };
		boolean flag = isArraySorted(A, A.length);
		System.out.println(flag);

	}
	//TC-O(n) 
	//SC-O(n)
	private static boolean isArraySorted(int[] A, int n) {
		
		if(n==0|| n==1)
			return true;
		
		return A[n-1]>A[n-2] && isArraySorted(A,n-1);
	}

}
