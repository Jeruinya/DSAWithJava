package com.scaler.dsa.sorting;

import java.util.Arrays;

/*
Given N integers, calculate number of noble integers in the array.
Noble integer =>>number of elements <arr[i]==arr[i]
 */
public class FindNobleIntegersForLessValue {

	public static void main(String[] args) {
		int A[] = {0, 2, 2, 4,4,6};		
		int n=A.length;	
		int less=0;
		Arrays.sort(A);
		int ans=0;
		if(A[0]==0)
			ans++;
		for(int i=1;i<n;i++) {
			if(A[i]==A[i-1])
				continue;
			else
				less=i;
			if(A[i]==less)
				ans++;
		}
		
		System.out.println(ans);

	}

}
