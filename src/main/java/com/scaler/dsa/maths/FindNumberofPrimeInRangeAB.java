package com.scaler.dsa.maths;

import java.util.Scanner;

/*
Given Q queries of form [a,b], find out number of the count of primes in range [a,b] where a,b<=10^6

Q=5

a		b
3		10
10		100
5		10000
200		2000
1500	3500
 */
public class FindNumberofPrimeInRangeAB {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		for (int i = 1; i <= q; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int res = countPrimesInRange(a, b);
			System.out.println(res);
		}

	}

	private static int countPrimesInRange(int a, int b) {
		int n = Math.max(a, b);
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int i = 2; i * i <= n; i++) {
			if (prime[i] == true) {
				for (int j = i * i; j <= n; j = j + i)
					prime[j] = false;
			}
		}

		int ps[] = new int[n + 1];
		ps[0] = 0;
		ps[1] = 0;
		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				ps[i] = ps[i - 1] + 1;
			else
				ps[i] = ps[i - 1];
		}
		
		

		return ps[n]-ps[a];
	}

}
