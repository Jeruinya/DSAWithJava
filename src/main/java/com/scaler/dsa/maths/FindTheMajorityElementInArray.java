package com.scaler.dsa.maths;

/*
Given N +ve elements in integer array Find majority element,element with frequency >N/2 is called frequency majority element.
A[]= {1 2 1 6 1 1} 
Here frequency of 1 is 4 and N/2  =6/2=3 , clearly 4>3 so majority element is 1.

Algorithm of deleting two different elements are called Moore's Voting Algorithm
 */
public class FindTheMajorityElementInArray {

	public static void main(String[] args) {
		int A[] = { 1, 2, 1, 6, 1, 1 };

		int element = A[0];
		int freq = 1, n = A.length;
		for (int i = 1; i < n; i++) {
			if (A[i] == element)
				freq++;
			else {
				if (freq == 0) {
					element = A[i];
					freq = 1;
				} else
					freq--;
			}
		}
		int count=0;
		for(int i=0;i<n;i++) {
			if(A[i]==element)
				count++;
		}
		
		if(count>n/2)
			System.out.println(element +":Is majority element and its frequency is:"+count);
		else
			System.out.println("No majority element");
			

	}

}
