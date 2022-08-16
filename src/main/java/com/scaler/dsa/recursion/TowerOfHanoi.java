package com.scaler.dsa.recursion;

/*
Tower of Hanoi is a game.
Suppose we have three towers A,B,C and n disks on top of tower A.
Goal: Transfer all the disks from tower A to tower C.
Rule:
1-pick only one disk at a time.
2:Never place a big disk over smaller one.

An example with 2 disks :
Step 1 : Shift first disk from 'A' to 'B'
Step 2 : Shift second disk from 'A' to 'C'
Step 3 : Shift first disk from 'B' to 'C'

An example with 3 disks :
Step 1 : Shift first disk from 'A' to 'C'
Step 2 : Shift second disk from 'A' to 'B'
Step 3 : Shift first disk from 'C' to 'B'
Step 4 : Shift third disk from 'A' to 'C'
Step 5 : Shift first disk from 'B' to 'A'
Step 6 : Shift second disk from 'B' to 'C'
Step 7 : Shift first disk from 'A' to 'C'.

Observation: 
1-Move n-1 disk from A to B
2-Move 1 disk from A to C
3-Move n-1 disk from B to C

so total number of steps will be (Move n-1 disk from A to B + Move 1 disk from A to C + Move n-1 disk from B to C
 */
public class TowerOfHanoi {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(numberOfStepsToPerform(n));
		System.out.println(numberOfStepsToPerformEff(n));
		System.out.println(numberOfStepsToPerformMoreEff(n));

	}

	// TC-O(2^n)
	private static int numberOfStepsToPerform(int n) {
		if (n == 0)
			return 0;
		return numberOfStepsToPerform(n - 1) + 1 + numberOfStepsToPerform(n - 1);
	}

	// TC-O(n)
	private static int numberOfStepsToPerformEff(int n) {
		if (n == 0)
			return 0;
		return 2 * numberOfStepsToPerform(n - 1) + 1;
	}

	// TC-O(n)
	private static int numberOfStepsToPerformMoreEff(int n) {
		return (1 << n) - 1;
	}

}
