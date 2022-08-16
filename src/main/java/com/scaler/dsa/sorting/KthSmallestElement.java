package com.scaler.dsa.sorting;
/*
Problem Description
Find the Bth smallest element in given array A .
NOTE: Users should try to solve it in less than equal to B swaps.

Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)
1 <= A[i] <= 109

Input Format
The first argument is an integer array A.
The second argument is integer B.
Output Format
Return the Bth smallest element in given array.

Input 1:A = [2, 1, 4, 3, 2] B = 3
Input 2:A = [1, 2] B = 2

Output 1: 2
Output 2: 2

Explanation 1:
 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.
 */
public class KthSmallestElement {

	public static void main(String[] args) {
		int A[]= {2, 1, 4, 3, 2};
		int  B = 3;
		int res=findKthSmallest(A,B);
		System.out.println(res);
		

	}

	private static int findKthSmallest(int[] A, int B) {
		
		int n=A.length;
		for(int i=0;i<n-1;i++) {
			int idx=i;
			for(int j=i+1;j<n;j++) {
				if(A[j]<A[idx])
					idx=j;					
			}
			
			int temp=A[idx];
			A[idx]=A[i];
			A[i]=temp;
		}
		return A[2];
	}

}
