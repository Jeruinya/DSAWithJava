package com.scaler.dsa.pattern;

import java.util.Scanner;

public class CharacterStairPattern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int letter = 65;
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {

				System.out.print((char) letter);
				if (i != j)
					System.out.print(" ");
			}
			letter++;
			System.out.println();
		}

	}
}