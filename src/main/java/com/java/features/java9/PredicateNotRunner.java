package com.java.features.java9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
//Predicate.not() was introduced in java 11
public class PredicateNotRunner {
    public static void main(String args[]) throws IOException {
        List<Integer> numbers = List.of(1, 10, 2, 31, 21, 45, 20);
        Predicate<Integer> evenNum = number -> number % 2 == 0;
        numbers.stream().filter(evenNum).forEach(System.out::println);
        numbers.stream().filter(evenNum.negate()).forEach(System.out::println);

        numbers.stream().filter(Predicate.not(PredicateNotRunner::isEven)).forEach(System.out::println);
    }

    private static boolean isEven(Integer num) {
        return num % 2 == 0;
    }
}
