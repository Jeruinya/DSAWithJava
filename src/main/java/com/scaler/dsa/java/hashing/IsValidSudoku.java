package com.scaler.dsa.java.hashing;

import java.util.HashSet;
import java.util.List;

/*


In a valid sudoko, there should be no repeating numbers in a row, column and a 33 box.
We can use set or map for finding if there are any repeating elements/numbers.
Approach :: 
1. Check if there are any repeating numbers in a row. 
2. Check if there are any repeating numbers in a column. 
3. Check if there are any repeating numbers in a box matrix(3 * 3).

If all the above didn’t have any repeating numbers then it is a valid sudoko.
 */
public class IsValidSudoku {

	public static void main(String[] args) {

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
