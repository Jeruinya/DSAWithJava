package com.java.features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitAndSkipMethodUsage {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight");

		List<String> res = list.stream().limit(5).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(res);
		
		List<String> res1 = list.stream().skip(5).collect(Collectors.toList());
		System.out.println(res1);

	}

}
