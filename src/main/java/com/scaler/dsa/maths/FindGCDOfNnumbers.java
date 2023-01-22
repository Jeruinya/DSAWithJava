package com.scaler.dsa.maths;

public class FindGCDOfNnumbers {

	public static void main(String[] args) {
		int A[]= {10,20,30,42,64};
		System.out.println(getGcdOfNNumbers(A));

	}

	private static int getGcdOfNNumbers(int[] A) {
		int gcd=A[0];
		for(int i=1;i<A.length;i++) {
			gcd=getGcd(A[i],gcd);
		}
		return gcd;
	}

	private static int getGcd(int a, int b) {
		int a1,b1;
		while(a!=0) {
			a1=b%a;
			b1=a;
			a=a1;
			b=b1;
		}
		return b;
	}

}
