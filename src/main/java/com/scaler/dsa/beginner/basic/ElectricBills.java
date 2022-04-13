package com.scaler.dsa.beginner.basic;
import java.util.Scanner;
/** 
 Given an integer A denoting the amount of units of electricity consumed, you have to calculate the electricity bill (in Rs.) 
 with the help of the below charge conditions:

For first 50 units Rs. 0.50/unit
For next 100 units Rs. 0.75/unit
For next 100 units Rs. 1.20/unit
For unit above 250 Rs. 1.50/unit
An additional surcharge of 20% is added to the bill.
NOTE: As the electricity bill can have any real value (floating point), you have to tell the floor value of the bill.
Floor value of a floating point is the closest integer less than or equal to that value. For eg, Floor value of 2.91 is 2.
   
**/

public class ElectricBills {

	public static int solve(int a) {
		double billAmt = 0;
		if (a > 0 && a <= 50) {
			billAmt = a * 0.5;
		} else if (a <= 150) {
			billAmt = 50 * .5 + (a - 50) * 0.75;
		} else if (a <= 250) {
			billAmt = 50 * .5 + 100 * 0.75 + (a - 150) * 1.2;
		} else {
			billAmt = (50 * 0.5) + (100 * 0.75) + (100 * 1.2) + (100 * 1.5) + (a - 350) * 1.5;
		}
		return (int) (billAmt + billAmt * 0.2);
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int result = solve(a);
		System.out.println(result);
	}
}