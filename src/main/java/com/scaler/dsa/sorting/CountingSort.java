package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
It takes O(n+k) times to sort n elements in range from 0 to n-1.
A[]=[1,4,4,1,0,1]  range k=5
 */
public class CountingSort {

	public static void main(String[] args) {
		int A[]= {1,4,4,1,0,1};
		int k=5;
		countSort(A,k);
		System.out.println(Arrays.toString(A));

	}

	private static void countSort(int[] A, int k) {
		int n= A.length;
		int count[]=new int[k];
		for(int i=0;i<n;i++) 
			count[A[i]]++;
		
		int idx=0;
		for(int i=0;i<k;i++) {
			for(int j=0;j<count[i];j++) {
				A[idx]=i;
				idx++;
			}
		}
		
	}

}
