package com.scaler.dsa.java.string;

public class TestingClass {

	public static void main(String[] args) {
		String str="Allstate is an insurance company";
		
		for(int i=0;i<str.length();i++) {
			System.out.print(str.charAt(i)+" ");
			
			System.out.print(str.indexOf(i)+" ");
			
			System.out.println();
		}

	}

}
