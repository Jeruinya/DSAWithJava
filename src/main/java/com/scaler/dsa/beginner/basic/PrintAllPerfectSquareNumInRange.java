package com.scaler.dsa.beginner.basic;

public class PrintAllPerfectSquareNumInRange {

	public static void main(String[] args) {
		int s = 10, e = 100;
		for (int i = s; i <= e; i++) {
			if (isPerfectSquare(i))
				System.out.print(i + " ");
		}

	}

	static boolean isPerfectSquare(int x) {
		if (x >= 0) {
			int sr = (int) Math.sqrt(x);
			return ((sr * sr) == x);
		}
		return false;
	}
}