package com.scaler.dsa.beginner.basic;

public class PrintAllPerfectSquareNumInRange {

	public static void main(String[] args) {
		int s=10,e=100;
		for(int i=s;i<=e;i++) {
			int sq= (int) Math.sqrt(i);
			if(sq*sq==i)
				System.out.print(i+" ");;
		}

	}

}
