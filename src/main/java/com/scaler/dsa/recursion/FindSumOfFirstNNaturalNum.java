package com.scaler.dsa.recursion;

public class FindSumOfFirstNNaturalNum {

	public static void main(String[] args) {
		int n=10;
		int res=sum(n);
		System.out.println(res);

	}

	private static int sum(int n) {
		if(n==1)
			return 1;		
		return (sum(n-1)+n);
	}

}
