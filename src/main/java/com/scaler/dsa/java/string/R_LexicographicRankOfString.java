package com.scaler.dsa.java.string;

/*
Given a string str, find its rank among all its permutations when sorted lexicographically.
Note: The characters a string are all unique.

Input: str = “acb”
Output: 2
Explanation: If all the permutations of the string are arranged lexicographically they will be 
“abc”, “acb”, “bac”, “bca”, “cab”, “cba”. From here it can be clearly that the rank of str is 2.

Approach:

Let the given string be “STRING”. In the input string, ‘S’ is the first character. 
There are total 6 characters and 4 of them are smaller than ‘S’. So there can be 4 * 5! 
smaller strings where first character is smaller than ‘S’, like following.

G X X X X X
R X X X X X
I X X X X X
N X X X X X
Similarly we can use the same process for the other letters. Fix ‘S’ and find the smaller strings starting with ‘S’. 

Repeat the same process for T, rank is 4*5! + 4*4! +. . . 
Now fix T and repeat the same process for R, rank is 4*5! + 4*4! + 3*3! + . . .
Now fix R and repeat the same process for I, rank is 4*5! + 4*4! + 3*3! + 1*2! + . . . 
Now fix I and repeat the same process for N, rank is 4*5! + 4*4! + 3*3! + 1*2! + 1*1! + . . .
Now fic N and repeat the same process for G, rank is 4*5! + 4*4! + 3*3! + 1*2! + 1*1! + 0*0!  
If this process is continued the rank = 4*5! + 4*4! + 3*3! + 1*2! + 1*1! + 0*0! = 597. 
The above computations find count of smaller strings. Therefore rank of given string is count of smaller strings plus 1. 
The final rank = 1 + 597 = 598

Follow the steps mentioned below to implement the idea:
Iterate the string from i = 0 to length of string:
Find the number of characters smaller than the current character.
Calculate the number of lexicographically smaller that can be formed using them as shown above.
Add that value to the rank.
At the end, add 1 with rank and return it as the required answer. [the reason is mentioned above]



 */
public class R_LexicographicRankOfString {

	static final int CHAR = 256;

	public static void main(String args[]) {
		String str = "STRING";
		System.out.print(lexRank(str));
	}

	static int fact(int n) {
		return (n <= 1) ? 1 : n * fact(n - 1);
	}

	static int lexRank(String str) {
		int res = 1;
		int n = str.length();
		int mul = fact(n);
		int[] count = new int[CHAR];
		for (int i = 0; i < n; i++)
			count[str.charAt(i)]++;
		for (int i = 1; i < CHAR; i++)
			count[i] += count[i - 1];
		for (int i = 0; i < n - 1; i++) {
			mul = mul / (n - i);
			res = res + count[str.charAt(i) - 1] * mul;
			for (int j = str.charAt(i); j < CHAR; j++)
				count[j]--;
		}
		return res;
	}
}