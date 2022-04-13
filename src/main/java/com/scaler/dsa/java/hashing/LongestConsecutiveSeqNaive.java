package com.scaler.dsa.java.hashing;

import java.util.Arrays;

public class LongestConsecutiveSeqNaive {
	
	    public static void main (String[] args) 
	    {
	        int arr[] = new int[]{1, 9, 3, 4, 2, 10, 13};	        
	        int n = arr.length;	        
	        System.out.println(findLongest(arr, n ));	        
	    }
	   //Need to find the longest consecutive sequence in the form of x,x+1,x+2....x+iwith elements appearing in any order 
	    static int findLongest(int arr[], int n)
	    {
	        Arrays.sort(arr);
	        int res=1,curr=1;
	        for(int i=1;i<n;i++){
	            if(arr[i]==arr[i-1]+1)
	                curr++;
	            else{
	                res=Math.max(res,curr);
	                curr=1;
	            }
	        }
	        res=Math.max(res,curr);
	        return res;
	    }
	}