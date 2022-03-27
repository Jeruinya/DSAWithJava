package com.scaler.beginner.basic;

import java.util.Scanner;

public class CheckArmStrongNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			int res = 0;
			int temp = i;
			if (temp == 1) {
				System.out.println(temp);
			} else {
				while (temp > 0) {
					int rem = temp % 10;
					res = res + rem * rem * rem;
					temp = temp / 10;
				}
				if (res == i)
					System.out.println(i);
			}

		}

	}
}