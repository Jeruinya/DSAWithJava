package com.java.features.java8;

import java.util.stream.Stream;

public class AnyMatch {

	public static void main(String[] args) {
		Stream<String> stream =
			    Stream.of("d2", "a2", "b1", "b3", "c")
			        .filter(s -> s.startsWith("a"));

			boolean b=stream.anyMatch(s -> true);    
			System.out.println(b);
			//stream.forEach(System.out::printf);
			//stream.noneMatch(s -> true);   // exception
	}

}
