package com.scaler.dsa.java.greedy;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description
The monetary system in DarkLand is really simple and systematic. The locals-only use coins. 
The coins come in different values. The values used are:
 1, 5, 25, 125, 625, 3125, 15625, ...
Formally, for each K >= 0 there are coins worth 5K.
Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary 
to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).

Problem Constraints
1 <= A <= 2×109

Input Format
The only argument given is integer A.

Output Format
Return the smallest number of coins necessary to pay exactly the cost of the item.

Input 1: A = 47
Input 2: A = 9

Output 1: 7
Output 2: 5

Explanation 1:
 Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).

Explanation 2:
 Representation of 5 coins will be : (1 + 1 + 1 + 1 + 5).
 */
public class CoinProblem {

	public static void main(String[] args) {
		int A = 47;
		System.out.println(findMinCoins(A));
		System.out.println(findMinCoins1(A));

	}

	public static int findMinCoins1(int A) {
		ArrayList<Integer> v = new ArrayList<>();

		int val = 1;

		// Storing all denominations of coins
		while (val <= 2000000000) {
			v.add(val);
			val = val * 5;
		}
		// Sort in decreasing order
		Collections.reverse(v);

		int ans = 0;
		// Loop from the largest denomination
		for (int i = 0; i < v.size(); i++) {
			ans += A / v.get(i);
			A = A % v.get(i);
		}
		return ans;
	}

	public static int findMinCoins(int A) {
		int ans = 0;
		while (A > 0) {
			ans = ans + A % 5;
			A = A / 5;
		}
		return ans;
	}
}
