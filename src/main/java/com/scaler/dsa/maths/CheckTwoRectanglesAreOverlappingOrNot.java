package com.scaler.dsa.maths;
/*

Fist rectangle in left and second rectangle in the right:
If C<=E then Rectangle is not overlapping---A,B(1,1) C,D(4,4)  E,F(5,6) G,H(7,7)

Second rectangle in left and first  rectangle in the right:
if(	A>=G)--->Then rectangle is not overlapping--

If(B>=H)--->Then rectangle is not overlapping--A,B(1,6)  C,D(8,6)  E,F(2,2)  G,H(4,5)

IF(A>=G || C<=E || B>=H || F>=D  Then no overlapping rectangle formed 
 */
public class CheckTwoRectanglesAreOverlappingOrNot {

	public static void main(String[] args) {
		int A = 0, B = 0, C = 4, D = 4, E = 2, F = 2, G = 6, H = 6;

		if (A == C || B == D || E == G || F == H)
			System.out.println("Not Overlapping");
		if (A >= G || E >= C)
			System.out.println("Not Overlapping");
		if (B >= H || F >= D)
			System.out.println("Not Overlapping");

		System.out.println("Two rectangles are Overlapping");
	}
}
