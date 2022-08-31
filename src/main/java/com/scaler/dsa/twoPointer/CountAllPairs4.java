package com.scaler.dsa.twoPointer;

/*
Given a sorted array of integers (not necessarily distinct) A and an integer B, 
find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).


Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).

Input 1:
A = [1, 1, 1]
B = 2
Input 2: 
A = [1, 1]
B = 2

Output 1: 3
Output 2: 1

Explanation 1:
 Any two pairs sum up to 2.

Explanation 2:
 only pair (1, 2) sums up to 2.
 */
public class CountAllPairs4 {

	public static void main(String[] args) {
		int A[] = { 1, 1, 1 };
		int B = 2;
		System.out.println(countPairs(A, B));

	}

	public static int countPairs(int[] A, int B) {
		int i = 0;
		int j = A.length - 1;
		long count = 0;
		long mod = 1000000007;
		while (i < j) {
			if (A[i] + A[j] == B) {
				long count1 = 0;
				long count2 = 0;
				int temp1 = A[i];
				int temp2 = A[j];
				while (i < A.length && A[i] == temp1) {
					i++;
					count1++;
				}
				while (j >= 0 && A[j] == temp2) {
					j--;
					count2++;
				}

				if (temp1 != temp2) {
					count += (count1 * count2);
				} else {
					count += (count1 * (count1 - 1)) / 2;
				}

				count = (count + mod) % mod;
			} else if (A[i] + A[j] > B)
				j--;
			else
				i++;
		}
		return (int) count;
	}

}
