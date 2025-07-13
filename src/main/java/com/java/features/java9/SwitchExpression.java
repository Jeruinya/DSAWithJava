package com.java.features.java9;
//Create expressions using switch statement
//Release in jdk14
// In switch statement there is a fall through means if there is no break below statements will get executed but in switch expression there is no fall through

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
        String dayOfWeek = switch (day) {
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
        return dayOfWeek;
    }

    public static void main(String args[]) {
        System.out.println(findDayOfWeeks(3));
        System.out.println(findDayOfWeeksWithSwitchExpression(3));

    }
}
