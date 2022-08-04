package com.scaler.dsa.maths;

import java.util.Scanner;

public class FindGCDOfNNumbersReadFromConsol {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int gcd=s.nextInt();
		for(int i=1;i<n;i++) {
			int no=s.nextInt();
			gcd=getGcd(gcd,no);
		}
		System.out.println(gcd);
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
