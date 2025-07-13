package com.java.features.java9;

// Text block is introduced in java 15 to simplify the complex text strings.
// After 3 double quotes the character should be in new line otherwise will get error
//Automatic alignment is done
//Trailing white spaces is stripped
//First line is """ followed by line terminator
public class TextBlockRunner {
    public static void main(String args[]) {
        System.out.println("\"First Line\"\n Second Line \n Third Line");
        String textBlock = """ 
                "First Line"
                Second Line
                Third Line
                   Fourth Line
                          Fifth Line
                """;
        System.out.println(textBlock);

    }
}
