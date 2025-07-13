package com.java.features.java9;

//Create expressions using switch statement
//Release in jdk14
// In switch statement there is a fall through means if there is no break below statements will get executed but in switch expression there is no fall through
// Before java 17 in switch we can pass Numeric, Enum and String but from java 17 onwards we can pass object as well
//When in switch its allowing objects then its called pattern matching
public class SwitchExpression {

    public static String findDayOfWeeks(int day) {
        String dayOfWeek = "";
        switch (day) {
            case 0:
                dayOfWeek = "Sunday";
                break;
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6:
                dayOfWeek = "Saturday";
                break;
            default:
                throw new IllegalArgumentException("Invalid Option " + day);
        }
        return dayOfWeek;
    }

    public static String findDayOfWeeksWithSwitchExpression(int day) {
        return switch (day) {
            case 0 -> {
                System.out.println(("Do some complex logic"));
                yield "Sunday";
            }
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> throw new IllegalArgumentException("Invalid Option " + day);
        };
    }

    //Pattern matching is supported in java 21 onwards
    /*static String patternMatching(Object obj){
        return switch(obj){
            case Integer i->"Integer"+i;
            case String s->"String"+s;
            case null->"Null Value";
            default -> "Unknown Type";

        }
    }*/

     /*static String classifyNumber(Number num){
        return switch(num){
            case Integer i->i%2==0 ? "Even Number": "Odd Number";
            case Double d->d>0? "Positive Number": "Negative Number";
            default -> "Unknown Number";

        }
    }*/

    public static void multipleValuePerCase(int num) {
        switch (num) {
            case 1:
                System.out.println("One");
            case 2:
            case 3:
            case 4:
                System.out.println("Two, Three or Four");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    public static void multipleValuePerCaseWith17(int num) {
        switch (num) {
            case 1:
                System.out.println("One");
            case 2, 3, 4:
                System.out.println("Two, Three or Four");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    public static void main(String args[]) {
        System.out.println(findDayOfWeeks(3));
        System.out.println(findDayOfWeeksWithSwitchExpression(3));
        multipleValuePerCase(2);
        multipleValuePerCaseWith17(2);

    }
}
