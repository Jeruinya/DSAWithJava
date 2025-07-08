package com.java.features.java9;

import java.util.List;

public class TypeInferencesRunner {
    public static void main(String args[]) {
        List<String> names1= List.of("Raju","Rohan");
        List<String> names2= List.of("Ram","Shyam");
        List<List<String>> names= List.of(names1, names2);
        System.out.print(names);

       // var names = List.of(names1, names2);
       // names.stream().forEach(System.out::println);
        // List<List<String>> names= List.of(names1, names2) == var names = List.of(names1, names2) but not working and giving error so commented
    }
}
