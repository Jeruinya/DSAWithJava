package com.collections.programs.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;

public class StreamUtilities {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println(stats);
		
		Random random = new Random();
		random.ints().limit(3).sorted().forEach(System.out::println);
		
		int min=1;
		int max=26;
		System.out.println(random.nextInt(max - min) + min);

	}

}
