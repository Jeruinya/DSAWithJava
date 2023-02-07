package com.scaler.dsa.java.string;

/*
Generate all cyclic permutations of a number
 */
public class R_GenerateAllCyclicPermutaionOfString {

	public static void main(String[] args) {
		int n = 5436;
		cyclicNumber(n);

		String s = "abc";
		cyclicString(s);

	}

	private static void cyclicString(String s) {
		String str = s;
		int n = s.length() - 1;
		while (true) {
			System.out.println(str);
			str = str.charAt(n) + str.substring(0, n);

			if (str.equals(s))
				break;
		}
	}

	private static void cyclicNumber(int n) {
		int num = n;
		int count = countDigits(n);

		while (true) {
			System.out.println(num);

			int rem = num % 10;
			int dev = num / 10;
			num = (int) (Math.pow(10, count - 1) * rem + dev);

			if (num == n)
				break;
		}
	}

	private static int countDigits(int n) {
		int count = 0;
		while (n > 0) {
			count++;
			n = n / 10;
		}
		return count;
	}

}
