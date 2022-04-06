package com.scaler.arrays;

public class LittlePonnyAndMaxElement {

	public static void main(String[] args) {
		int A[]= { 24, 33, 13, 11, 30, 28, 19, 8, 30, 25, 42, 6, 30, 49, 3, 49, 24, 13, 3, 50 };
		int B=13;
		int count=0;
        boolean flag=false;
        for(int i=0;i<A.length;i++){
            if(A[i]==B) {
                flag=true;
                break; 
            }
        }
        if(flag==true){
            for(int i=0;i<A.length;i++)
                if(A[i]>B)
                    count++;
            
        }
        
        if(flag==true)
        	System.out.println(count);
        else
        	System.out.println(-1);
    }
}
