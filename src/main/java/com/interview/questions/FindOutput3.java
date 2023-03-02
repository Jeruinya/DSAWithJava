package com.interview.questions;

public class FindOutput3 {
	public static void main(String[] args) {

		Integer i = Integer.valueOf(12);

		System.out.print(i + " ");

		modify(i);

		System.out.print(i);
	}

	private static void modify(Integer i) {
		i = i + 1;
	}

}
