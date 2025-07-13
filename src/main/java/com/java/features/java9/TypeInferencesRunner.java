package com.java.features.java9;

import java.util.List;

//Java 10 introduced the var keyword for local variables with initializers.
// The compiler infers the type of the variable from the type of the value assigned to it.
//var can also be used in loops.
//you can not assign null to var variable
//var is not a keyword  var var= "Pune"; its fine
// var variable can be used to improve the readability of chained expression.
public class TypeInferencesRunner {
    public static void main(String args[]) {
        List<String> names1= List.of("Raju","Rohan");
        List<String> names2= List.of("Ram","Shyam");
        List<List<String>> names= List.of(names1, names2);
        System.out.println(names);

        final var message = "Hello, World!"; //we can create var as final also
       System.out.println(message);
       var names3 = List.of(names1, names2);
       names3.stream().forEach(System.out::println);
        // List<List<String>> names= List.of(names1, names2) == var names = List.of(names1, names2) but not working and giving error so commented
    }
}
