package com.collections.programs.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctUsage {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Jack Fruit");
		list.add("Water melon");
		list.add("Apple");
		System.out.println(list);
		
		List<String> res = list.stream().distinct().collect(Collectors.toList());
		System.out.println(res);

	}

}
