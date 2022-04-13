package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class CheckANumberIsPerfectNumber {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if (n >= 1 && n <= 10) {
			for (int i = 1; i <= n; i++) {
				int sum = 1;
				int a = s.nextInt();

				for (int j = 2; j * j <= a; j++) {
					if (a % j == 0) {
						if (j * j == a)
							sum = sum + j;
						else
							sum = sum + j + a / j;
					}
				}

				if (sum == a)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}

	}
}