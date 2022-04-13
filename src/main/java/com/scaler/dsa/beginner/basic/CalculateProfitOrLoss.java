package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

/**
 * Problem Description
 * You are given the Cost Price C and Selling Price S of a Product. You have to
 * tell whether there is a Profit or Loss. Also, calculate total profit or loss.
 * 
 * NOTE: It is guaranteed that Cost Price and Selling Price are not equal.
 */

public class CalculateProfitOrLoss {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cp = s.nextInt();
		int sp = s.nextInt();
		int profit = sp - cp;
		if (profit > 0) {
			System.out.println(1);
			System.out.println(profit);
		} else {
			System.out.println(-1);
			System.out.println(-profit);
		}

	}
}