package com.scaler.dsa.bitManipulation;

public class FindTwoUniqueNumbers {

	public static void main(String[] args) {
		uniqueNumber2();
	}
	
	 public static void uniqueNumber2(){
	        int[] arr = {7,6,4,5,4,5,7,8};
	        //step-1 xor all
	        int xor = 0;
	        for(int x:arr){
	            xor = xor^x;
	        }
	        //step-2 find out the position of rightmost set bit
	        int pos=0;
	        int temp = xor;
	        while((temp&1)!=1){
	            temp = temp>>1;
	            pos++;
	        }

	        //step-3 filter out no's from the array which have 1 at pos
	        int setA = 0;
	        for(int x:arr){
	            if((x & (1<<pos)) > 0){
	                setA = setA^x;
	            }
	        }

	        // print the result
	        System.out.println(setA);
	        System.out.println(xor^setA);
	    }

}
