package com.interview.questions;

import java.util.HashSet;

public class Findoutput17 {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<String>();
		set.add(null);
		set.add("One");
		for (String s : set)
			System.out.println(s);

	}

}
