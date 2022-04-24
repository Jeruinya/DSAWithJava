package com.scaler.dsa.bitManipulation;

public class CheckiThBitOnOrOff {

	public static void main(String[] args) {

		int n=35;
		int i=3;
		if((n>>i-1&1)==1)
			System.out.println("ON");
		else
				System.out.println("OFF");
			

	}

}
