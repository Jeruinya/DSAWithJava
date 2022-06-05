package com.scaler.dsa.java.string;

/*
Write a program to convert the string with its indexes. 
String A=abc  then output should be -a1b2c3     , A=abz-----a1b2z26
 */
public class ContestQuestion1 {

	public static void main(String[] args) {
		String A = "abxzyml";
		String res = "";
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			int index = c - 'a' + 1;
			res = res + c + index;
		}
		System.out.println(res);
	}

}
