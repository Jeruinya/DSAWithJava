package com.scaler.dsa.binarySearch;
/*
Given a sorted array with 2N+1 elements find out unique element in the array.
	A[]= {1,1,3,3,4,4,5,6,6,7,7};
		  0 1 2 3 4 5 6 7 8 9 10
observation:
1-Numbers are coming in pairs and from the above array we can observe that first repeating number is starting at even index
before the unique number.

2-After the unique number first repeating number is starting from odd indexes
Do dry run on below arrays:
{1,1,3,3,4,4,5,5,6,7,7}
 */
public class FindOutUniqueElement {

	public static void main(String[] args) {
		int A[]= {1,1,3,3,4,4,5,6,6,7,7};
		System.out.println(findUniqueNumber(A));

	}

	private static int findUniqueNumber(int[]A) {
		int s=0;
		int n=A.length;
		int e=n-1;
		
		if(n==1)
			return A[0];
		if(A[0]!=A[1])
			return A[0];
		if(A[n-1]!=A[n-2])
			return A[n-1];
		
		while(s<=e) {
			int mid=(s+e)/2;
			if((A[mid]!=A[mid-1]) && (A[mid]!=A[mid+1]))
				return A[mid];
			else if((mid%2==0 && A[mid]==A[mid+1])||(mid%2!=0 && A[mid]==A[mid-1]))
				s=mid+1;
			else
					e=mid-1;
		}
		return -1;
	}

}
