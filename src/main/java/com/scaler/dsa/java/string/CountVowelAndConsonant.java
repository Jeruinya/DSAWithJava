package com.scaler.dsa.java.string;

public class CountVowelAndConsonant {

		// Method 1
		// To prints number of vowels and consonants
		public static void count(String str)
		{
			// Initially initializing elements with zero
			// as till now we have not traversed
			int vow = 0, con = 0;
		
			// Declaring a reference String
			// which contains all the vowels
			String ref = "aeiouAEIOU";
		
			for (int i = 0; i < str.length(); i++) {
				
				// Check for any special characters present
				// in the given string
				if ((str.charAt(i) >= 'A'
					&& str.charAt(i) <= 'Z')
					|| (str.charAt(i) >= 'a'
						&& str.charAt(i) <= 'z')) {
					if (ref.indexOf(str.charAt(i)) != -1)
						vow++;
					else
						con++;
				}
			}
		
			// Print and display number of vowels and consonants
			// on console
			System.out.println("Number of Vowels = " + vow
							+ "\nNumber of Consonants = "
							+ con);
		}

		// Method 2
		// Main driver method
		public static void main(String[] args)
		{
			// Custom string as input
			String str = "#GeeksforGeeks";
		
			// Callin gthe method 1
			count(str);
		}
	}
