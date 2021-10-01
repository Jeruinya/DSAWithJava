package com.collections.programs;

import java.util.Stack;

//Deutche bankprogram
public class GenericStack {
	int val=10;

	Stack<Integer> stk = new Stack<Integer>();

	public void push(Integer e) {
		stk.push(e);
	}

	public Integer pop() {
		Integer i = stk.pop();
		return i;
	}

	public static void main(String[] args) {
		GenericStack gs = new GenericStack();
	
		gs.push(36);
		System.out.println(gs.pop());
		System.out.println(gs);
		System.out.println("--"+gs.val);

		try {
			int j, sum;
			sum = 10;
			for (j = -1; j < 3; ++j)
				sum = (sum / j);
		} catch (ArithmeticException e) {
			System.out.println("0");
		}
		// System.out.println(sum);

	}
}
