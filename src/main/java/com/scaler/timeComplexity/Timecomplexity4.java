package com.scaler.timeComplexity;

public class Timecomplexity4 {

	public static void main(String[] args) {
		int n=50;
		for(int i=3;i<n/3;i=i+3) {
			System.out.println("i="+i);
			int count=0;
			for(int j=2;j<n/2;j=j+2) {
				count++;
			}
			System.out.println("Number of iterations in inner loop="+count);
		}

	}

}
