package com.scaler.dsa.arrays;

import java.util.ArrayList;

/*
Given N array elements ,calculate in how many OR subarrays 0th bit is 1

A=[7,4,8]

			Subarrays				subarrays OR's			Binary
			[7]	 						7					0 1 1 1 
			[7,4]						7					0 1 1 1
			[7,4,8]						15					1 1 1 1
			[4]							4					0 1 0 0
			[4,8]						12					1 1 0 0
			[8]							8					1 0 0 0
So here there are 4 Subarrays OR will have last or 0th bit as set or one.
If we are interested in the last bit or 0th bit then rest bit dont do anything.

A=[5,8,26,13,5,21]
	
	5			0 0 1 0 1
	8			0 1 0 0 0 
	26			1 1 0 1 0
	13			0 1 1 0 0
	5			0 0 1 0 1
	21			1 0 1 0 1
If we want to know about 0th bit from subarrays OR , we need 0th bit from the array.

				 Total subarrays-number of subaarays with 0 OR
b0=[1 0 0 0 1 1]	21-3=18
b1=[0 0 1 0 0 0]	21-9=12
b2=[1 0 0 1 1 1]	21-3=18
b3=[0 1 1 1 0 0]	21-4=17
b4=[0 0 1 0 0 1]	21-6=15
	
 */
public class Sub_CountHowManyORSubarrays0thBitIsZero {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5};
		
		int sumOR=solve(A);
		System.out.println(sumOR);

	}

	 public static int solve(int[] A) {
	        long sum = 0;
	       
	        int mod=1000000007;
	        for(int i=0;i<30;i++){
	            ArrayList<Integer> al= new ArrayList<>();
	            
	            for(int j=0;j<A.length;j++){
	                if(((A[j]>>i)&1)==1)
	                    al.add(1);
	                else
	                    al.add(0);
	            }
	            long count=countOR1(al);
	            sum=(sum%mod +(count*(long)(Math.pow(2,i)))%mod)%mod;

	        }
	 
	        return (int) (sum % mod); 
	    }

	   public static long countOR1(ArrayList<Integer> al) {
			int c = 0;
			int n = al.size();
			long ans = 0;

			for (int i = 0; i < n; i++) {
				if (al.get(i) == 0)
					c++;
				else {
					ans = ans + ((1L*c*(1L*c+1)))/2;
					c = 0;
				}
			}
			
			ans = ans + ((1L*c*(1L*c+1)))/2;
			
			long totalSubarrays=(1L*n*(1L*n+1))/2;
			return totalSubarrays-ans;

		}
	}
