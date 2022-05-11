package com.scaler.dsa.java.string;
/*
Problem Description
Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.

Input Format
First argument is a string A of size N.
Output Format
Return the resultant string.

Example Input   A="AbcaZeoB"
Example Output  "bc###bc###"
 */

public class StringOperations {

	public static void main(String[] args) {
		String A = "hgUe";
		String str = A + A;
		StringBuilder sb = new StringBuilder();
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//Here not taking "aeiouAEIOU" Uppercase needs to remove
		String vowels = "aeiou";

		for (int i = 0; i < str.length(); i++) {

			if (vowels.contains(String.valueOf(str.charAt(i))))
				sb.append('#');
			else if (!(str.charAt(i) >= 65 && str.charAt(i) <= 90))
				sb.append(str.charAt(i));
		}
		System.out.println(sb);
	}

}
