package com.scaler.dsa.maths;

/*
Given a number in array form of the array(A) , find A%p.
A=[1,2,3,4]===1234
p=5,   1234%5=4

constraints:
1<=N<=10^3
1<=p<=10^9

So here N is the size of array and number of digits in the newly formed number from array
example-- A=[1,2,3,4], A.size=4   and A=1234 and number of digits is also same i.e 4.

Number can be:
N=1			9						10^1-1
N=2			99						10^2-1
N=3			999						10^3-1
N=4			9999					10^4-1
.
.
.
.
N=1000			9999.......9			10^1000-1


 */
public class FindModuloOfArrayElements {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4 };
		int n = A.length;
		int p = 5;

		System.out.println(findModOfArrayElementsNaive(A, n, p));

		System.out.println(findModOfArrayElementsEfficient(A, n, p));

	}

	private static int findModOfArrayElementsEfficient(int[] A, int n, int p) {
		int ans = 0, power = 1;
		for (int i = n - 1; i >= 0; i--) {
			ans = (ans + ((A[i] % p) * power)) % p;
			power = (power * 10) % p;
		}

		return ans;
	}

	private static long findModOfArrayElementsNaive(int[] A, int n, int p) {
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans = (ans + (A[i] % p * power(10, n - i - 1, p)) % p) % p;
		}
		return ans;
	}

	private static long power(int a, int m, int p) {
		long ans = 1;
		for (int i = 0; i < m; i++)
			ans = (ans % p * a % p) % p;
		return ans;
	}

}
