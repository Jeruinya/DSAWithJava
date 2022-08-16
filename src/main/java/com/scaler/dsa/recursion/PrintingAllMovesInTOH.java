package com.scaler.dsa.recursion;

public class PrintingAllMovesInTOH {

	public static void main(String[] args) {
		int n=3;
		char src='A', helper='B', dest='C';
		toh(n,src,helper,dest);

	}

	private static void toh(int n, char src, char helper, char dest) {
		if(n==0)
			return;
		toh(n-1,src,dest,helper);
		System.out.println("Moving "+n+" disk from "+src+" to "+dest);
		toh(n-1,helper,src,dest);
		//System.out.println("Moving"+n+"disk from"+src+"to"+dest);
		
	}

}

