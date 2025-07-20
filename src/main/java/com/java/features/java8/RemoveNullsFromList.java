package com.java.features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveNullsFromList {
    public static void main(String[] args) {
        List<String> listWithNulls = Arrays.asList("apple", null, "banana", null, "cherry");
        List<String> res = listWithNulls.stream().filter(Objects::nonNull).toList();
        List<String> res1 = listWithNulls.stream().filter(Objects::isNull).toList();
        System.out.println(res);
        System.out.println(res1);

    }
}
