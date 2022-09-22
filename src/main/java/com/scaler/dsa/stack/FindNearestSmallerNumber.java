package com.scaler.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/*
Given an array of size n, find the nearest smaller number for every element that is present on the left.

A={1,6,4,12,3,8}
o/p: {-1,1,1,4,1,3}
 */
public class FindNearestSmallerNumber {

	public static void main(String[] args) {
		int A[] = { 1, 6, 4, 12, 3, 8 };
		int res[] = nearestSmaller(A);
		System.out.println(Arrays.toString(res));
		
		int res1[] = nearestSmallerEff(A);
		System.out.println(Arrays.toString(res1));

	}

	private static int[] nearestSmallerEff(int[] A) {
		 int n = A.length;
			int res[] = new int[n];
			Stack<Integer> s= new Stack<>();

	        for(int i=0;i<n;i++){
	            while(!s.isEmpty() && s.peek()>=A[i])
	                s.pop();
	           
	            if(s.isEmpty())
	                res[i]=-1;
	            else
	                res[i]=s.peek();
	            s.push(A[i]);
	        }
			return res;
		
	    }

	private static int[] nearestSmaller(int[] A) {
		int n = A.length;
		int res[] = new int[n];
		res[0] = -1;

		for (int i = 0; i < n; i++) {
			int j = i - 1;
			for (; j >= 0; j--) {
				if (A[j] < A[i]) {
					res[i] = A[j];
					break;
				}
			}
			if (j == -1)
				res[i] = -1;
		}
		return res;
	}

}
