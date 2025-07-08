package com.java.features.java9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyOfAPI {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Mohan");
        list.add("Sohan");
        list.add("Raju");
        //List<String> l=List.of("A","B","C"); // is introduced in java 9 to create unmodifiable list
        List<String> list1 = List.copyOf(list);
        doNotChange(list1); //this method call will result into UnsupportedOperationException
        System.out.print(list1);
    }

    private static void doNotChange(List<String> list) {
        list.add("Kamal");
    }

}
