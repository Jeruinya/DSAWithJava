package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
it is in-place algorithm which means it does not take any extra space.
its stable which means when there are two duplicate elements then it maintain the original insertion order.
used in practice for small sizer of array.
O(n) time complexity in best case and o(n^2) in worst case.
 */
public class InsertionSort {

	public static void main(String[] args) {
		int A[]= {20,5,40,60,10,30};
		insertionSort(A);
		System.out.println(Arrays.toString(A));

	}

	private static void insertionSort(int[] A) {
		int n= A.length;
		
		for(int i=1;i<n;i++) {
			int key=A[i];
			int j=i-1;
			while(j>=0 && A[j]>key) {
				
				A[j+1]=A[j];
				j--;
			}
			A[j+1]=key;
		}
		
	}

}
