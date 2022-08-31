package com.scaler.dsa.arrays;

/**
 * Problem Description: N light bulbs are connected by a wire. Each bulb has a
 * switch associated with it; however, due to faulty wiring, a switch also
 * changes the state of all the bulbs to the right of the current bulb. Given an
 * initial state of all bulbs, find the minimum number of switches you have to
 * press to turn on all the bulbs. You can press the same switch multiple times.
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 * 
Observation:
A[i]=0------------> odd flips will be 1 and even flips will be same .
A[i]=1------------> odd flips will be 0 and even flips will be same .
 */

public class FindMininmumNumberOfFlip {

	public static void main(String[] args) {
		int A[] = { 0, 1, 0, 1 };
		int n = A.length;

		int numberOfSwitch3 = countFlipsNaive(A, n);
		System.out.println(numberOfSwitch3);

		int A1[] = { 0, 1, 0, 1 };
		int numberOfSwitch = countFlipsEfficient(A1, n);
		System.out.println(numberOfSwitch);

		int A2[] = { 0, 1, 0, 1 };
		int numberOfSwitch1 = countFlips(A2, n);
		System.out.println(numberOfSwitch1);

	}

	private static int countFlipsNaive(int[] A, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == 0) {
				for (int j = i; j < n; j++) {
					A[j] = 1 - A[j];
				}
				count++;
			}
		}
		return count;
	}

	public static int countFlipsEfficient(int[] A, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if ((A[i] == 0 && count % 2 == 0) || (A[i] == 1 && count % 2 == 1))
				count++;
		}
		return count;
	}

	public static int countFlips(int a[], int n) {
		int state = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (state == a[i]) {
				if (state == 0)
					state = 1;
				else
					state = 0;
				count++;
			}
		}
		return count;
	}
}
