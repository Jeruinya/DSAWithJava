package com.scaler.beginner.basic;

import java.util.Scanner;

/**
 * Enter month and year and telltell how many days are there in the month.
 * Months are denoted as follows: January : 1 February : 2 March : 3 April : 4
 * May : 5 June : 6 July : 7 August : 8 September : 9 October : 10 November : 11
 * December : 12
 */

public class NumberOfDaysInMonth {

	public static void main(String[] strings) {

		Scanner input = new Scanner(System.in);

		int number_Of_DaysInMonth = 0;
		String MonthOfName = "Unknown";

		System.out.print("Input a month number: ");
		int month = input.nextInt();

		System.out.print("Input a year: ");
		int year = input.nextInt();

		switch (month) {
		case 1:
			MonthOfName = "January";
			number_Of_DaysInMonth = 31;
			break;
		case 2:
			MonthOfName = "February";
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
				number_Of_DaysInMonth = 29;
			} else {
				number_Of_DaysInMonth = 28;
			}
			break;
		case 3:
			MonthOfName = "March";
			number_Of_DaysInMonth = 31;
			break;
		case 4:
			MonthOfName = "April";
			number_Of_DaysInMonth = 30;
			break;
		case 5:
			MonthOfName = "May";
			number_Of_DaysInMonth = 31;
			break;
		case 6:
			MonthOfName = "June";
			number_Of_DaysInMonth = 30;
			break;
		case 7:
			MonthOfName = "July";
			number_Of_DaysInMonth = 31;
			break;
		case 8:
			MonthOfName = "August";
			number_Of_DaysInMonth = 31;
			break;
		case 9:
			MonthOfName = "September";
			number_Of_DaysInMonth = 30;
			break;
		case 10:
			MonthOfName = "October";
			number_Of_DaysInMonth = 31;
			break;
		case 11:
			MonthOfName = "November";
			number_Of_DaysInMonth = 30;
			break;
		case 12:
			MonthOfName = "December";
			number_Of_DaysInMonth = 31;
		}
		System.out.print(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days\n");
	}
}