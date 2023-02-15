package com.scaler.dsa.recursion;

/*
Indian currencies: [1,2 5,10, 20, 50, 100, 200, 500, 2000]
int denominator[]=[1,2 5,10, 20, 50, 100, 200, 500, 2000]

RS=276: get the a change using minimum notes/coins

276=200+50+20+5+1=5
 */
public class MoneyChange {

	static int denominator[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

	public static void main(String[] args) {
		int n = 276;
		System.out.println(moneyChange(n));

	}

	private static int moneyChange(int money) {
		if (money == 0)
			return 0;
		int note = findLargest(money);
		return (money / note) + moneyChange(money % note);
	}

	private static int findLargest(int money) {
		int note = 1;
		for (int i = 0; i < denominator.length; i++) {
			if (denominator[i] <= money)
				note = denominator[i];
		}
		return note;
	}

}
