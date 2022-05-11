package com.scaler.dsa.java.string;

public class FindLongestCommonPrefix {

	public static void main(String[] args) {
		String str[] = { "abcdefgh", "aefghijk", "abcefgh" };
		String ans="";
		int min_len_str = Integer.MAX_VALUE;
		for (int i = 0; i < str.length; i++) {
			int len = str[i].length();
			min_len_str = Math.min(min_len_str, len);
		}
		for(int i=0;i<min_len_str;i++) {
			//char c= 
			
		}

	}

}
