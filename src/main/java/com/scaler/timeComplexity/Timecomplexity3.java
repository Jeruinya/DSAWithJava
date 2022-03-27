package com.scaler.timeComplexity;

public class Timecomplexity3 {

	
	//O(n)
	public static void main(String[] args) {
		
		int n=32;
		for (int i = n; i > 0; i /= 2) {
			int count = 0;
			System.out.println("i="+i);
			for (int j = 0; j < i; j++) {
				count += 1;
			}
			System.out.println("Count of inner loop="+count);
		}
	}

}
