package com.scaler.dsa.java.string;

public class CountNumberOfDivisiblePairs {

	public static void main(String[] args) {
		String A[]= {"12","15","16"};
		int B=2;
		int count=solve(A,B);
		System.out.println(count);

	}
	 public static  int solve(String[] A, int B) {
	        int count =0;
	        for(int i=0;i<A.length;i++){
	            String res=A[i];
	            for(int j=0;j<A.length;j++){
	                if(i!=j){
	                    String s=A[j];
	                    String s2=res+s;
	                    long num=Integer.parseInt(s2);
	                    if(num%B==0)
	                        count++;
	                }
	            }
	        }
	        return count;
	    }
	}