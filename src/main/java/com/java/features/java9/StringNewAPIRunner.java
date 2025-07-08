package com.java.features.java9;

import java.io.IOException;

//These methods introduced in java 11 in String class
public class StringNewAPIRunner {
    public static void main(String args[]) {
        System.out.println("         ".isBlank());
        System.out.println("        ".isEmpty());
        System.out.println("    LR    ".strip());
        System.out.println("  LR  ".stripLeading().replace(" ", "@"));
        System.out.println("  LR  ".stripTrailing().replace(" ", "@"));
        "Line1\nLine2\nline3".lines().forEach(System.out::println);
       String str="UPPER".transform(s-> s.substring(2));
       System.out.println(str);
       System.out.println("My name is %s. My age is %d".formatted("Kamlesh",34));

       System.out.print("Hello");

    }
}
