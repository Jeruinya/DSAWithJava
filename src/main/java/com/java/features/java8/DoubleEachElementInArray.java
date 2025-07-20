package com.java.features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DoubleEachElementInArray {
    public static void main(String args[]) {
        int[] a = {8, 4, 9, 4, 5, 6};
        int[] result = IntStream.of(a).flatMap(i -> IntStream.of(i, i)).toArray();
        List<Integer> list = Arrays.stream(result).boxed().toList();
        System.out.println(list);
        List<Integer> doubleList = list.stream().map(i -> i * 2).toList();
        System.out.println(doubleList.size());
        Long l = doubleList.stream().filter(i -> i > 2).count();// not working
        System.out.println(l);
    }
}
