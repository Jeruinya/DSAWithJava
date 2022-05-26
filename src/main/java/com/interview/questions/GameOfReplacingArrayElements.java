package com.interview.questions;

import java.util.HashSet;

/*
There are two players A and B who are interested in playing a game of numbers. 
In each move a player pick two distinct number, let’s say a1 and a2 and then replace all a2 by a1 or a1 by a2. 
They stop playing game if any one of them is unable to pick two number and the player who is 
unable to pick two distinct number in an array, loses the game. First player always move first and then second. 
Task is to find which player wins. 

Examples: 

Input :  arr[] = { 1, 3, 3, 2,, 2, 1 }
Output : Player 2 wins
Explanation:
	First plays always loses irrespective
	of the numbers chosen by him. For example,
	say first player picks ( 1 & 3) 
	replace all 3 by 1  
	Now array Become { 1, 1, 1, 2, 2, 1 }
	Then second player picks ( 1  2 )
	either he replace 1 by 2 or 2 by 1 
	Array Become { 1, 1, 1, 1, 1, 1 }
	Now first player is not able to choose.

Input  : arr[] = { 1, 2, 1, 2 }
Output : Player 1 wins

Observation-->From above examples, we can observe that if number of count of distinct element is even, 
			  first player always wins. Else second player wins.
 */
public class GameOfReplacingArrayElements {

	public static int playGame(int arr[]) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i : arr)
			hs.add(i);

		return (hs.size() % 2 == 0) ? 1 : 2;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 1, 2, 2, 2, 2 };
		System.out.print("Player " + playGame(arr) + " wins");
	}
}
