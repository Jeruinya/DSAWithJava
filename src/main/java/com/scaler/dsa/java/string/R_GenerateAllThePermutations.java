package com.scaler.dsa.java.string;

/*
Given a string str, the task is to print all the permutations of str. A permutation is an arrangement of all or 
part of a set of objects, with regard to the order of the arrangement. For instance, the words ‘bat’ and ‘tab’ 
represents two distinct permutation (or arrangements) of a similar three letter word.

Examples: 
Input: str = “cd” 
Output: cd dc
Input: str = “abb” 
Output: abb abb bab bba bab bba 
 */
public class R_GenerateAllThePermutations {

	public static void main(String[] args) {
		String s = "abb";
		generatePermutations(s, "");
		System.out.println();
		printDistinctPermutn(s, "");

	}

	private static void generatePermutations(String s, String ans) {
		if (s.length() == 0) {
			System.out.print(ans+" ");
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String r = s.substring(0, i) + s.substring(i + 1);

			generatePermutations(r, ans + c);
		}

	}

	static void printDistinctPermutn(String str, String ans) {

		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		boolean alpha[] = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			if (alpha[ch - 'a'] == false)
				printDistinctPermutn(ros, ans + ch);
			alpha[ch - 'a'] = true;
		}
	}

}
