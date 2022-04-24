package com.scaler.dsa.bitManipulation;

public class CountNumberOfSetBits {

	public static void main(String[] args) {
		int n=25;
		int c1=countNumberOfSetBitsNaive(n);
		System.out.println(c1);
		
		int c2=countNumberOfSetBitsEfficient(n);
		System.out.println(c2);

	}

	//Here number of iterations is 5 only and time complexity is O(logN)--here logN is better than O(1)
	//And this situation is called Bigo drawback
	private static int countNumberOfSetBitsEfficient(int n) {
		int c=0;
		while(n>0) {
			if((n&1)==1)
				c++;
			n=n/2;
		}
		return c;
	}

	// Number of iterations is 32 --O(1)
	private static int countNumberOfSetBitsNaive(int n) {
		 int c=0; 
		 for(int i=0;i<32;i++)
			 if(((n>>i)&1)==1)
				 c++;
		return c;
	}

}
