package com.scaler.dsa.timeComplexity;

public class Timecomplexity5 {

	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i<(1<< n); i++) {
			System.out.println("i<(1<< n)=="+ (1<<n));
			System.out.println("i="+i+" n="+n);
			int j = i;
			while (j > 0) {
				j = j - 1;
				System.out.println("j="+j);
			}
		}
	}
}