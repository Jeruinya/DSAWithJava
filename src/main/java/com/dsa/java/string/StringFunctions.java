package com.dsa.java.string;

public class StringFunctions {

	public static void main(String args[]) {
		// Creates a string literal
		String str = "geeks";

		// Returns the number of
		// characters in the String.
		System.out.println(str.length());

		// Returns the character at ith index.
		System.out.println(str.charAt(3));

		// Return the substring from the
		// ith index character
		// to end of string
		System.out.println(str.substring(2));

		// Returns the substring from i to j-1 index.
		System.out.println(str.substring(2, 5));

		// Creating two string literals
		String s1 = "geeksforgeeks";
		String s2 = "geeks";

		// Returns the first occurrence of
		// s2 in s1 after index 1
		System.out.println(s1.indexOf(s2));

		// Creating two string literals
		String ss1 = "geeksforgeeks";
		String ss2 = "for";

		int res = ss1.compareTo(ss2);

		if (res == 0)
			System.out.println("Same");
		if (res > 0)
			System.out.println("s1 is Greater");
		if (res < 0)
			System.out.println("s1 is Smaller");
		
		String sss1 = "geeksforgeeks";
        String sss2 = "geeksforgeeks";
        
        // Whether s2 equal to s1
        System.out.println(sss1.equals(sss2));
        
        String ssss1 = "geeksforgeeks";
        String ssss2 = "geeks";
        
        // Whether s2 is present in s1 or not
        // true
        System.out.println(ssss1.contains(ssss2));
        
        String str1 = "geeks";
        String str2 = "geeks";
        
        // Checking if both point to the
        // same object or not
        if(str1 == str2)
            System.out.println("Yes");
        else
            System.out.println("No");
        
        // Creating a string using 
        // new operator
        String s3 = new String("geeks");
        // Checking if both point to the
        // same object or not
        if(s1 == s3)
            System.out.println("Yes");
        else
            System.out.println("No");
        
        String str3 = "geeks";
        String str4 = str3;
        
        // Creates a new object "geeksforgeeks"
        // Now s1 points to this new string
        str3 = str3 + "forgeeks";
        // or
        // s1 = s1.concat("forgeeks");
        
        System.out.println(str3);
        
        // Since s2 is still pointing 
        // to initial "geeks"
        // and s1 is pointing to a new 
        // object "geeksforgeeks"
        System.out.println(str3 == str4);
	}

}
