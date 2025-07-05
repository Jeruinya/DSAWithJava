package com.java.features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenArrayList {

	public static void main(String[] args) {
		List<List<Integer>> listOfList=Arrays.asList(Arrays.asList(1,2),Arrays.asList(5,6));
		List<Integer> res=listOfList.stream().flatMap(x->x.stream()).collect(Collectors.toList());
		System.out.println(res);

	}

}
