package com.scaler.dsa.java.string;

import java.util.Arrays;

public class GivenACharacterArrayAndSortIt {

	public static void main(String[] args) {
		char c[] = { 'd', 'a', 'b', 'a', 'c', 'd', 'b' };
		// T.C -O(nlogn)
		// Arrays.sort(c);
		// System.out.println(Arrays.toString(c));

		sortChar(c);
		System.out.println(Arrays.toString(c));

	}
	//TC-O(n)
	private static void sortChar(char[] c) {
		int A[] = new int[26];
		for (int i = 0; i < c.length; i++) 
			A[c[i]-'a']++;
		
		int curr_index=0;
		for(int i=0;i<26;i++) {
			for(int j=0;j<A[i];j++) {
				c[curr_index]=(char)(i+'a');
				curr_index++;
			}
		}

	}

}
