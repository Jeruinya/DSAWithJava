package com.scaler.dsa.java.string;

import java.util.Arrays;

public class ToggleEveryCharacterSmallToCapitalAndCapitalToSmall {

	public static void main(String[] args) {
		char s[]= {'A','n','a','C','o','n','D','a'};
			upperToLowerAndLowerToUpper(s);
			System.out.println(Arrays.toString(s));
			
			char s1[]= {'K','a','M','l','e','s','H'};
			
			upperToLowerAndLowerToUpperUsingBitwiseXOR(s1);
			System.out.println(Arrays.toString(s1));
			

	}

	private static void upperToLowerAndLowerToUpperUsingBitwiseXOR(char[] s1) {
		for(int i=0;i<s1.length;i++) {
			s1[i]=(char)(s1[i]^32);
		}
		
	}

	private static void upperToLowerAndLowerToUpper(char[] s) {
		for(int i=0;i<s.length;i++) {
			if(s[i]>=65 && s[i]<=90)
				s[i]=(char)(32+s[i]);
			else
				s[i]=(char)(s[i]-32);
		}
		
	}

}
