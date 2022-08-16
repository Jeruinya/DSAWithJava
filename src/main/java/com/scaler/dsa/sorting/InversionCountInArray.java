package com.scaler.dsa.sorting;

/*
Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. 
Find the total number of inversions of A modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the number of inversions of A modulo (109 + 7).

Input 1:A = [3, 2, 1]
Input 2:A = [1, 2, 3]

Output 1:3
Output 2:0

Explanation 1:
 All pairs are inversions.
Explanation 2:
 No inversions.
 
 A[]=[4,5,1,2,7,3]  pairs-(4,1) (4,2) (4,3)    (5,1) (5,2) (5,3)   (7,3)   Answer is 7
 
 */
public class InversionCountInArray {

	public static void main(String[] args) {
		int A[] = { 4, 5, 1, 2, 7, 3 };
		System.out.println(countInversionPairsNaive(A));

		int A1[] = { 4, 5, 1, 2, 7, 3 };
		System.out.println(countInversionsEff(A1,0,A.length-1));
	}

	public static int countInversionPairsNaive(int[] A) {

		int n = A.length;
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (A[i] > A[j])
					count++;
		return count;
	}
	
	
	private static int countInversionsEff(int[] A, int s, int e) {
		if(s>=e) {
			return 0;
		}
		int mid=(s+e)/2;
		int left=countInversionsEff(A,s,mid);
		int right=countInversionsEff(A,mid+1,e);
		int total=left+ right+merge(A,s,mid,e);
		return total;
	}

	private static int merge(int[] A, int s, int mid, int e) {
		int temp[]=new int[e-s+1];
		int i=s;
		int j=mid+1;
		int count=0;
		int k=0;
		
		while(s<=mid && j<=e) {
			if(A[i]<=A[j]) {
				temp[k]=A[i];
				k++;
				i++;	
			}
			else {
				temp[k]=A[j];
				k++;
				j++;
				count=count+(mid-i+1);
			}
		}
		while(i<=mid) {
			temp[k]=A[i];
			i++;
			k++;
		}
		
		while(j<=e) {
			temp[k]=A[j];
			j++;
			k++;
		}
		
		for (i = s; i <= e; i++)
			A[i] = temp[i-s];
		
		return count;
	}
}
