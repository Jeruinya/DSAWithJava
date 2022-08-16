package com.scaler.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

Problem Constraints
-1010 <= A[i], B[i] <= 1010

Input Format
First Argument is a 1-D array representing A.
Second Argument is also a 1-D array representing B.
Output Format
Return a 1-D vector which you got after merging A and B.

Input 1:A = [4, 7, 9 ]
B = [2, 11, 19 ]
Input 2:
A = [1]
B = [2]

Output 1:[2, 4, 7, 9, 11, 19]
Output 2:[1, 2]

Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.
 */
public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int A[]= {-4,3};
		int B[]= {-2,-2};
		int [] res=combineAndSort(A,B);
		System.out.println(Arrays.toString(res));

		int A1[]= {-4,3};
		int B1[]= {-2,-2};
		//int [] res1=combineAndSortEff(A1,B1);
		//System.out.println(Arrays.toString(res1));

	}
	
	 public static int[] combineAndSort(final int[] A, final int[] B) {

	        int res[]=new int[A.length+B.length];

	        for(int i=0;i<A.length;i++)
	            res[i]=A[i];
	        int k=0;
	        for(int i=A.length;i<res.length;i++)
	            res[i]=B[k++];

	        Arrays.sort(res);

	        return res;
	    }
	 
	 public static ArrayList < Integer > combineAndSortEff(final List < Integer > A, final List < Integer > B) {
	        int m = A.size(), n = B.size();
	        ArrayList < Integer > res = new ArrayList < Integer > ();
	        if (A == null && B == null)
	            return null;
	        if (A == null) {
	            for (int i = 0; i < n; i++)
	                res.add(B.get(i));
	            return res;
	        }
	        if (B == null) {
	            for (int i = 0; i < m; i++)
	                res.add(A.get(i));
	            return res;
	        }
	        int i, j;
	        int k = 0;
	        for (i = 0, j = 0; k < m + n; k++) {
	            if (i >= m)
	                res.add(B.get(j++));
	            else if (j >= n)
	                res.add(A.get(i++));
	            else if (A.get(i) <= B.get(j))
	                res.add(A.get(i++));
	            else
	                res.add(B.get(j++));
	        }
	        return res;
	    }

}
