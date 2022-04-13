package com.scaler.dsa.arrays;

/**
 * Given an array and q queries find- S E O sum of all odd indexed elements in[s:e]and SEE sum of all even indexed elements in [E:s]
 */

//Asked in DirectI and Flipkart
public class SumOfEvenAndOddIndexesBetweenRange {

	public static void main(String[] args) {
		int A[]= {2,3,1,6,4,5};
		int s=1,e=4;
		int s1=2,e1=5;
		int n=A.length;
		int PSe[]=new int[n];
		int PSo[]=new int[n];
		PSe[0]=A[0];
		PSo[0]=0;
			for(int i=1;i<n;i++) {
				if(i%2==0)
					PSe[i]=PSe[i-1]+A[i];
				else
					PSe[i]=PSe[i-1];
			}
			for(int i=1;i<n;i++) {
				if(i%2!=0)
					PSo[i]=PSo[i-1]+A[i];
				else
					PSo[i]=PSo[i-1];
			}
		
		int sumOfOddIndexes=PSo[e]-PSo[s-1];
		int sumOfEvenIndexes=PSe[e1]-PSe[s1-1];
		System.out.println("Sum of odd indexed elements="+sumOfOddIndexes);
		System.out.println("Sum of even indexed elements="+sumOfEvenIndexes);

	}

}
