package com.scaler.dsa.java.greedy;

/*
Problem Description
You are given a string A consisting of 1's and 0's. Now the task is to make the string consisting of only 1's. 
But you are allowed to perform only the following operation:
Take exactly B consecutive string elements and change 1 to 0 and 0 to 1.
Each operation takes 1 unit time, so you have to determine the minimum time required to only make the string of 1's. 
If not possible, return -1.


Problem Constraints
2 ≤ length of A ≤ 105
2 ≤ B ≤ (length of A)

Input Format
The first argument is a string A consisting of 1's and 0's.
The second argument is an integer B which represents the number of consecutive elements which can be changed.

Output Format
Return an integer which is the minimum time to make the string of 1's only or -1 if not possible.

Input 1:
 A = "00010110"
 B = 3
Input 2:
 A = "011"
 B = 3

Output 1: 3
Output 2: -1

Explanation 1:
 You can get 1 by first changing the leftmost 3 elements, getting to 11110110, then the rightmost 3, getting to 11110001, 
 and finally the 3 left out 0's to 11111111; In 3 unit time.

Explanation 2:
It's not possible to convert the string into string of all 1's.
 */
public class BinaryStrings {

	public static void main(String[] args) {
		String A = "00010110";
		int B = 3;
		System.out.println(solve(A, B));
	}

	// TC - O(n * B), SC - O(1) , TLE
	public static int solve(String A, int B) {
		char[] aCharArr = A.toCharArray();
		int count = 0;
		for (int i = 0; i < A.length(); i++) {
			if (aCharArr[i] == '0' && i + B <= A.length()) {
				count++;
				for (int j = i; j < i + B; j++) {
					if (aCharArr[j] == '0') {
						aCharArr[j] = '1';
					} else {
						aCharArr[j] = '0';
					}
				}
			}
			if (i + B > A.length()) {
				break;
			}
		}
		for (int i = 0; i < A.length(); i++) {
			if (aCharArr[i] == '0') {
				return -1;
			}
		}
		return count;

	}

	//TC - O(n), SC - O(n)
	public static int solveEff(String A, int B) {
		int n = A.length();
		// this array is used keep track of flip operation
		// example at any index i, we set i + B = 1, to keep track of when flip operation is getting over
		int[] flipMonitor = new int[n];

		// to keep track of number of flip operations performed
		int flipCount = 0;

		// to keep track of flip operation at every step
		// xor == 1 - flip is in progress
		// xor == 0 - no flip operation in progress
		int xor = 0;

		// observations
		// At any index i, if flip is not in progress i.e xor == 0 and A[i] == 0, it
		// means flip is required
		// Similarly we can say that at any index i, if flip is in progress i.e xor == 1
		// and A[i] == 1, it means flip is required
		// as flip in progress with A[i] == 1 means A[i] value is now 0, hence flip is
		// required again

		// We can perform flips only from 0 to n - B index
		// after n- B th index there is no enough B elements to perform flip operation
		// So, after n - B th index we will only check whether all subsequent element
		// resultant value is 1, if not then return -1
		for (int i = 0; i < n - B + 1; i++) {

			xor ^= flipMonitor[i]; // reset flip after B elements, since for i we are setting flipMonitor[i + B] = 1

			if ((xor == 0 && A.charAt(i) == '0') || (xor == 1 && A.charAt(i) == '1')) {
				// flip is required
				flipCount++;
				xor ^= 1; // flip is now in progress
				if (i + B < n) {
					flipMonitor[i + B] = 1;
				}
			}
		}

		for (int i = n - B + 1; i < n; i++) {
			xor ^= flipMonitor[i]; // if flipMonitor[i] is 1 then it will reset the xor

			if ((xor ^ (A.charAt(i) - '0')) == 0) {
				return -1;
			}
		}
		return flipCount;
	}

}
