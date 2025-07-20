package com.java.features.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of lists of integers, flatten it to a single list and sort it in ascending order.
public class FlattenArrayList {

    public static void main(String[] args) {
        List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(5, 6));
        List<Integer> res = listOfList.stream().flatMap(List::stream).sorted().toList();
        System.out.println(res);

    }

}
