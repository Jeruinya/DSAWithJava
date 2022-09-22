
package com.scaler.dsa.arrays;

public class Sub_PrintAllsubstringOfAgivenString {

	public static void main(String[] args) {
		String str = "abcd";
		printSubstring(str);
	}

	private static void printSubstring(String str) {
		for (int i = 0; i < str.length(); i++)
			for (int j = i + 1; j <= str.length(); j++)
				System.out.println(str.substring(i, j));
	}
}
