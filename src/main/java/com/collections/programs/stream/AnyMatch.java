package com.collections.programs.stream;

import java.util.stream.Stream;

public class AnyMatch {

	public static void main(String[] args) {
		Stream<String> stream =
			    Stream.of("d2", "a2", "b1", "b3", "c")
			        .filter(s -> s.startsWith("a"));

			stream.anyMatch(s -> true);    // ok
			stream.forEach(System.out::printf);
			//stream.noneMatch(s -> true);   // exception
	}

}
