package com.scaler.dsa.java.string;

public class StringRotations {

	
	//Check if are same after any number of rotations
	static boolean areRotations(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return ((s1 + s1).indexOf(s2) >= 0);
	}

	public static void main(String args[]) {
		String s1 = "ABCD";
		String s2 = "CDAA";
		String s3=s1+s1;
		
		System.out.println(s3);
		System.out.println(s3.indexOf(s2));
		
		
		  if (areRotations(s1, s2)) {
		  System.out.println("Strings are rotations of each other"); } else {
		  System.out.println("Strings are not rotations of each other"); }
		 
	}
}