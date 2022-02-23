package com.scaler.beginner.basic;

import java.util.Scanner;

public class BankAccount {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		long balance = s.nextLong();
		int numberOfOp = s.nextInt();

		for (int i = 0; i < numberOfOp; i++) {
			int type = s.nextInt();
			long amount = s.nextLong();
			if (type == 1) {
				balance = balance + amount;
				System.out.println(balance);
			} else if (type == 2) {
				if (amount <= balance) {
					balance = balance - amount;
					System.out.println(balance);
				} else
					System.out.println("Insufficient Funds");

			}
		}

	}
}