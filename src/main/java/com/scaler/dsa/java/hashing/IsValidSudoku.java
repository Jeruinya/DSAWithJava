package com.scaler.dsa.java.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.



The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

In a valid sudoko, there should be no repeating numbers in a row, column and a 3*3 box.
We can use set or map for finding if there are any repeating elements/numbers.
Approach :: 
1. Check if there are any repeating numbers in a row. 
2. Check if there are any repeating numbers in a column. 
3. Check if there are any repeating numbers in a box matrix(3 * 3).

If all the above didn’t have any repeating numbers then it is a valid sudoko.
 */
public class IsValidSudoku {

	public static void main(String[] args) {
		String s1 = "53..7....";
		String s2 = "6..195...";
		String s3 = ".98....6.";
		String s4 = "8...6...3";
		String s5 = "4..8.3..1";
		String s6 = "7...2...6";
		String s7 = ".6....28.";
		String s8 = "...419..5";
		String s9 = "....8..79";
		List<String> A = new ArrayList<>();
		A.add(s1);
		A.add(s2);
		A.add(s3);
		A.add(s4);
		A.add(s5);
		A.add(s6);
		A.add(s7);
		A.add(s8);
		A.add(s9);
		System.out.println(isValidSudoku(A));

	}

	public static int isValidSudoku(final List<String> A) {

		if (A == null)
			return 0;

		int n = A.size();

		if (n != 9 || A.get(0).length() != 9)
			return 0;

		HashSet<Character> hashSet = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			hashSet.clear();
			for (int j = 0; j < 9; j++) {
				char c = A.get(i).charAt(j);
				if (c == '.')
					continue;
				if (hashSet.contains(c))
					return 0;
				hashSet.add(c);
			}
		}

		for (int i = 0; i < 9; i++) {
			hashSet.clear();
			for (int j = 0; j < 9; j++) {
				char c = A.get(j).charAt(i);
				if (c == '.')
					continue;
				if (hashSet.contains(c))
					return 0;
				hashSet.add(c);
			}
		}

		for (int k = 0; k < 9; k++) {
			int x = k / 3;
			int y = k % 3;
			hashSet.clear();
			for (int i = 3 * x; i < 3 * x + 3; i++) {
				for (int j = y * 3; j < y * 3 + 3; j++) {
					char c = A.get(j).charAt(i);
					if (c == '.')
						continue;
					if (hashSet.contains(c))
						return 0;
					hashSet.add(c);
				}
			}

		}

		return 1;

	}

}
