package com.collections.programs.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectNumbersWhichAreDivisibleBy3AndEven {

	public static void main(String[] args) {
		List<Integer> list=  Arrays.asList(1,3,4,52,12,18,20,24,30);
		
		List<Integer> res= list.stream().filter(i->i%3==0).filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(res);
		
		

	}

}
