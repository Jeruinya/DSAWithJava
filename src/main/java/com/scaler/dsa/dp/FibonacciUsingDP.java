package com.scaler.dsa.dp;

public class FibonacciUsingDP {

	public static void main(String[] args) {
		int n = 5;
		int[] A = new int[n + 1]; // fib[i] denotes the i'th fibonacci number
		for (int i = 0; i <= n; i++)
			A[i] = -1;

		System.out.println(findNthFibonaccieTerm(n, A));
		System.out.println(findNthTermOfFib(n));
	}

	// Top down DP
	private static int findNthFibonaccieTerm(int n, int A[]) {

		if (n == 0 || n == 1)
			return n;
		if (A[n] != -1)
			return A[n];

		int ans = findNthFibonaccieTerm(n - 1, A) + findNthFibonaccieTerm(n - 2, A);
		A[n] = ans;

		return ans;

	}

	// Bottom Up DP
	private static int findNthTermOfFib(int n) {
		int A[] = new int[n + 1];
		A[0] = 0;
		A[1] = 1;
		for (int i = 2; i <= n; i++)
			A[i] = A[i - 1] + A[i - 2];

		return A[n];
	}
}