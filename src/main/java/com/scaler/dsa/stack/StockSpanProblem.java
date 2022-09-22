package com.scaler.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and 
we need to calculate the span of the stock’s price for all n days. The span Si of the stock’s price on a given 
day i is defined as the maximum number of consecutive days just before the given day, for which the price of the 
stock on the current day is less than its price on the given day. 

Input: N = 7, price[] = [100 80 60 70 60 75 85]
Output: 1 1 1 2 1 4 6

Explanation: Traversing the given input span for 100 will be 1, 80 is smaller than 100 so the span is 1,
 60 is smaller than 80 so the span is 1, 70 is greater than 60 so the span is 2 and so on. 
 Hence the output will be 1 1 1 2 1 4 6.
 
A Linear-Time Complexity Method 
We see that S[i] on the day i can be easily computed if we know the closest day preceding i,such that the price is 
greater than on that day than the price on the day i. If such a day exists, let’s call it h(i), otherwise, 
we define h(i) = -1. 
The span is now computed as S[i] = i – h(i).
 


 */
public class StockSpanProblem {

	public static void main(String[] args) {
		int price[] = { 100, 80, 60, 70, 60, 75, 85 };
		int res[] = stockSpan(price);
		System.out.println(Arrays.toString(res));

		int res1[] = stockSpanEff(price);
		System.out.println(Arrays.toString(res1));

	}

	private static int[] stockSpanEff(int[] stock) {
		int n = stock.length;
		Stack<Integer> s = new Stack<>();

		int span[] = new int[n];

		span[0] = 1;
		s.push(0);
		for (int i = 1; i < n; i++) {
			while (!s.isEmpty() && stock[i] >= stock[s.peek()])
				s.pop();

			span[i] = (s.isEmpty()) ? (i + 1) : (i - s.peek());
			s.push(i);

		}
		return span;
	}

	// O(n^2) O(n)
	private static int[] stockSpan(int[] A) {
		int n = A.length;
		int s[] = new int[n];
		s[0] = 1;
		for (int i = 1; i < n; i++) {
			s[i] = 1;

			for (int j = i - 1; (j >= 0) && (A[i] >= A[j]); j--)
				s[i]++;
		}
		return s;
	}
}