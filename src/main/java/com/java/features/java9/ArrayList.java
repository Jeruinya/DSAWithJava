package com.java.features.java9;

import java.util.Arrays;
import java.util.List;
//JEP JDK enhancement proposal document
//LTS  Long term supported version

public class ArrayList {
    public static void main(String args[]) {
        // Created a fixed size array
        Integer[] a = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.asList(a);
        a[0] = 1000;
        System.out.println(a);
        System.out.println(list);
        // a[3]=100; will through ArrayIndexOutOfBoundsException
    }
}
