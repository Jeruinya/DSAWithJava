package com.scaler.dsa.pattern;

/*
1
01
101
0101
10101
010101
1010101
01010101

 */
public class ZeroOneToggle {

	public static void main(String[] args) {
		int n = 5;

		for (int i = 1; i <= n; i++) {
			// print i no in every row
			int val = i % 2;
			for (int cnt = 1; cnt <= i; cnt++) {
				System.out.print(val);
				val = 1 - val;
			}
			// newline
			
			System.out.println();
		}

		// ternary op (if - else)
		for (int i = 1; i <= n; i++) {
			int val = i % 2;
			boolean x = val > 0 ? true : false;
			for (int cnt = 1; cnt <= i; cnt++) {
				System.out.print(val);
				x = !x;
				val = x == true ? 1 : 0;
			}
			System.out.println();
		}
	}
}