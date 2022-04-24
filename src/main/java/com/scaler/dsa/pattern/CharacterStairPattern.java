package com.scaler.dsa.pattern;

/*
A
B B
C C C
D D D D
E E E E E
F F F F F F
G G G G G G G
H H H H H H H H
 
 
 */

import java.util.Scanner;

public class CharacterStairPattern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int letter = 65;
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <=i; j++) {
				System.out.print((char) letter);
				if (i != j)
					System.out.print(" ");
			}
			letter++;
			System.out.println();
		}

	}
}