package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
In each iteration the bigger element moves to th end of the array by pairwise comparison.

A[]={4 5 3 1 2}

itr=0:  4 5 3 1 2
		4 3 5 1 2
		4 3 1 5 2
		4 3 1 2 5
itr=1:
		3 4 1 2 5
		3 1 4 2 5
		3 1 2 4 5
itr=2:
		1 3 2 4 5
		1 3 2 4 5
itr=3:
		1 3 2 4 5
		1 2 3 4 5   now its sorted
		
 */
public class BubbleSort {

	public static void main(String[] args) {
		int A[]={4 ,5 ,3, 1,-7,-1,5,9,9,8,0,0 ,2};
		bubbleSort(A);
		System.out.println(Arrays.toString(A));

	}
	//TC-o(n^2) Space-o(1)
	//n-1+ n-2+ n-3 + n-4 +..........1=(n-1)*n/2
	private static void bubbleSort(int[] A) {
		int n= A.length;
		for(int i=0;i<n-1;i++) 
			for(int j=0;j<n-i-1;j++)
				if(A[j]>A[j+1])
					swap(j,j+1,A);
		
	}

	private static void swap(int i, int j, int[] A) {
		int temp =A[i];
		A[i]=A[j];
		A[j]=temp;
		
	}

}
