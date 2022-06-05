package com.scaler.dsa.maths;

/*
Problem Description
Given a column title as appears in an Excel sheet, return its corresponding column number.
Problem Constraints
1 <= length of the column title <= 5
Input Format
The only argument is a string that represents the column title in the excel sheet.
Output Format
Return a single integer that represents the corresponding column number.

Input 1: AB
Input 2: ABCD
Output 1: 28
Output 2: 19010
Explanation 1:
 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 
 (ABCD)26----> 26^0 *4 + 26^1 * 3 + 26^2* 2 +26^3*1===>19010
 
 So we have to do same as we convert from hexadecimal to decimal or octal to decimal like that
 */
public class ExcelColumnNumber {

	public static void main(String[] args) {
		String A = "ABCD";
		int res = titleToNumber(A);
		System.out.println(res);

		int res1 = titleToNumber1(A);
		System.out.println(res1);
	}

	private static int titleToNumber1(String A) {
		int power = 1, ans = 0;
		int n = A.length();
		for (int i = n - 1; i >= 0; i--) {
			ans = ans + (A.charAt(i) - 'A'+1) * power;
			power = power * 26;
		}
		return ans;
	}

	private static int titleToNumber(String A) {
		int power = 1, ans = 0;
		int n = A.length();
		for (int i = n - 1; i >= 0; i--) {
			ans = ans + (int) (A.charAt(i) - 64) * power;
			power = power * 26;
		}
		return ans;
	}

}
