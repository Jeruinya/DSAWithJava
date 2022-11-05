package com.scaler.dsa.java.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Problem Description
The local ship renting service has a special rate plan:

It is up to a passenger to choose a ship.
If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
The passengers buy tickets in turn, the first person in the queue goes first, then the second one, 
and so on up to A-th person.

You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.

Problem Constraints
1 ≤ A ≤ 3000
1 ≤ B ≤ 1000
1 ≤ C[i] ≤ 1000
It is guaranteed that there are at least A empty seats in total.

Input Format
First argument is a integer A denoting the number of passengers in the queue.
Second arugument is a integer B deonting the number of ships.
Third argument is an integer array C of size B where C[i] denotes the number of empty seats in the 
i-th ship before the ticket office starts selling tickets.

Output Format
Return an array of size 2 denoting the maximum and minimum money that the ship company can earn.

Input 1:
 A = 4
 B = 3
 C = [2, 1, 1]
Input 2:
 A = 4
 B = 3
 C = [2, 2, 2]

Output 1: [5, 5]
Output 2: [7, 6]

Explantion 1:
 Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
 So, the cost will be 5.
 Minimum money can be earned if the passenger choose : 1(senocd ship) + 2(first ship) + 1(first ship) + 1(third ship).
 So, the cost will be 5.

Explanation 2:
 Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
 So, the cost will be 7.
 Minimum money can be earned if the passenger choose : 2(senocd ship) + 2(first ship) + 1(first ship) + 1(second ship).
 So, the cost will be 6.
 */
public class TheShipCompany {

	public static void main(String[] args) {
		int A = 4;
		int B = 3;
		int C[] = { 2, 1, 1 };
		int res[] = maxAndMinCost(A, B, C);
		System.out.println(Arrays.toString(res));
	}

	private static int[] maxAndMinCost(int A, int B, int[] C) {
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		int minValue = 0;
		int maxValue = 0;

		for (int num : C)
			max.add(num);

		for (int num : C)
			min.add(num);

		for (int i = 1; i <= A; i++) {
			int x = max.poll();
			maxValue = maxValue + x;
			int num = x - 1;
			if (num > 0)
				max.add(num);
		}

		for (int i = 1; i <= A; i++) {
			int x = min.poll();
			minValue = minValue + x;
			int num = x - 1;
			if (num > 0)
				min.add(num);
		}
		return new int[] { maxValue, minValue };
	}

}
