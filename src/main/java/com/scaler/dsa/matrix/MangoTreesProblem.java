package com.scaler.dsa.matrix;

/*
Ramu's father has left a farm organized as an N × N grid. Each square in the grid 
either has or does not have a mango tree. He has to divide the farm with his three 
sisters as follows: he will draw one horizontal line and one vertical line to divide the 
field into four rectangles. His sisters will choose three of the four fields and he gets 
the last one.
He wants to divide the field so that he gets the maximum number of mangos 
possible, assuming that his sisters will pick the best three rectangles.
For example, suppose the field looks as follows:

q2			q1
 . # # |. . .
 # . . |# # .
 . # . |. . .
-------|-----------------
 . # # |. . #
 # . . |# # .
 . # . |. . .
 
 q3			q4
 
 q1=2---Ramu's part mangos
 q2=4
 q3=4
 q4=3
 	   
Decide how to cut the field to maximize his mangos 

Goal: Maximize the minimum mangos by changing cut


Ramu can ensure that he will get atleast 3 mango trees by cutting as follows:

q2			q1
 . # |# . . .
 # . |. # # .
 . # |. . . .
 -----------------
 . # |# . . #
 # . |. # # .
 . # |. . . .
 
 q3		q4
 
 q1=3---Ramu's part mangos
 q2=3
 q3=3
 q4=4


 */
public class MangoTreesProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
