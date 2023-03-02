package com.interview.questions;

import java.util.TreeSet;

public class Findoutput18 {

	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("Scaler");
		treeSet.add("InterviewBit");
		treeSet.add("Coders");
		treeSet.add("Coders");

		for (String temp : treeSet)
			System.out.printf(temp + " ");

		System.out.println("\n");
	}
}