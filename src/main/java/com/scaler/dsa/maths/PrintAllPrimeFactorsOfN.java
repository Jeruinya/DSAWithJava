package com.scaler.dsa.maths;

/*
Prime factorization:
Number = product of powers of primes.
48= 2^4 * 5^1
51= 3^1 * 17^1
 */
public class PrintAllPrimeFactorsOfN {
	public static void main(String[] args) {
		int n = 12;
		printPrimeFactors(n);
		printPrimeFactorsEff(n);
	}

	// TC-O(N)
	private static void printPrimeFactors(int n) {
		int divisors = 1;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				int count = 0;
				while (n % i == 0) {
					n = n / i;
					count++;
				}
				System.out.print(i + "-" + count);
				System.out.print(",");
				System.out.println();
				divisors = divisors * (count + 1);
			}
		}
		System.out.println("All the divisors of Number N:" + divisors);

	}

	// TC-O(Root N)
	private static void printPrimeFactorsEff(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				int count = 0;
				while (n % i == 0) {
					n = n / i;
					count++;
				}
				System.out.print(i + "-" + count);
				System.out.print(",");
			}
		}
		if (n > 1)
			System.out.print(n + "-" + 1);
	}
}
