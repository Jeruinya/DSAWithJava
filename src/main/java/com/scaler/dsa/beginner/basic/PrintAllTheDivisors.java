package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class PrintAllTheDivisors {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		printDivisorsNaive(n);
		System.out.println();
		printDivisorsEfficient(n);
		System.out.println();
		printDivisorsEfficient1(n);
	}

	private static void printDivisorsEfficient1(int n) {
		int i;
		for (i = 1; i * i <n; i++) 
			if (n % i == 0) 
					System.out.print(i + " ");
		i=i-1;
		for(;i>=1;i--)
			if(n%i==0)
				System.out.print(n/i+" ");

	}
	
	private static void printDivisorsEfficient(int n) {
		int i;
		for (i = 1; i * i <n; i++) {
			if (n % i == 0) {
				if (i * i == n) {
					System.out.print(i + " ");
				} else {
					System.out.print(i+" ");
					System.out.print(n/i+" ");
				}
			}
		}

	}

	private static void printDivisorsNaive(int n) {

		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				System.out.print(i + " ");
		}
	}

}
