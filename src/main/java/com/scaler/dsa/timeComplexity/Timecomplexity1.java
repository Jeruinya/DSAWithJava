package com.scaler.dsa.timeComplexity;

public class Timecomplexity1 {

	public static void main(String[] args) {
		for (int i = 1; i <= 21; i = i + 2)// n is odd-- 1 3 5 7 9 11 13 15 17 19 21 .......n  a=1,d=2,--->a+(n-1)d==>N=1+(m-1)2==>n+1/2
			//O(n)
			System.out.print(i + " ");
		System.out.println();
		for (int i = 1; i <= 20; i = i + 2)// 1 3 5 7 9 11 13 15 17 19  .......n-1--->m=n+1/2 is also valid when n=even
			//O(n)
			System.out.print(i + " ");
		
		System.out.println();
		for (int i = 2; i <= 20; i = i + 2)// 2 4 6 8 10 12 14 16 18 20  ......n--->N/2==>O(N)
			System.out.print(i + " ");
		
		System.out.println();
		for (int i = 2; i <= 21; i = i + 2)// 2 4 6 8 10 12 14 16 18 20 ........ n-1---->N/2==>O(N)
			System.out.print(i + " ");
	}

}
