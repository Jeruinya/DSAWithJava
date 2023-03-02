package com.interview.questions;

import java.util.LinkedList;
import java.util.List;

public class Findoutput19 {

	public static void main(String[] args) {
		List<String> list1 = new LinkedList<>();
		list1.add("Scaler");
		list1.add("For");
		list1.add("Coders");
		list1.add("InterviewBit");
		list1.add("Coders");

		List<String> list2 = new LinkedList<>();
		list2.add("Coders");

		list1.removeAll(list2);

		for (String temp : list1)
			System.out.printf(temp + " ");

		System.out.println();

	}

}