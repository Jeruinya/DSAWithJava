package com.scaler.dsa.twoPointer;

/*
Problem Description
Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.

Problem Constraints
0 <= N <= 105
1 <= A[i] <= 105
Input Format
Single Argument representing a 1-D array A.

Output Format
Return single Integer denoting the maximum area you can obtain.

Input 1:A = [1, 5, 4, 3]
Input 2:A = [1]

Output 1: 6
Output 2: 0

Explanation 1:
 
5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3. 
So total area = 3 * 2 = 6

Explanation 2: 
No container is formed.
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int A[] = { 1, 5, 4, 3 };
		System.out.println(maxAreaNaive(A));
		System.out.println(maxAreaEff(A));

	}

	public static int maxAreaEff(int[] A) {
		int n = A.length;
		long ans = 0;
		int i = 0;
		int j = n - 1;

		while (i < j) {
			long s1 = j - i;
			long s2 = Math.min(A[i], A[j]);
			long res = s1 * s2;
			ans = Math.max(ans, res);

			if (A[i] <= A[j])
				i++;
			else
				j--;
		}

		return (int) ans;
	}

	public static int maxAreaNaive(int[] A) {
		long ans = 0;
		long n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				long s1 = j - i;
				long s2 = Math.min(A[i], A[j]);
				long res = s1 * s2;

				ans = Math.max(ans, res);
			}
		}

		return (int) ans;
	}
}
