package com.dsa.java.hashing;

import java.util.HashSet;

public class LongestConsecutiveSeqEffic {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 9, 3, 4, 2, 10, 13 };
		int n = arr.length;
		System.out.println(findLongest(arr, n));
	}

	//Need to find the longest consecutive sequence in the form of x,x+1,x+2....x+iwith elements appearing in any order 
	//Here we are using hashing to find the longest consecutive sequence
	static int findLongest(int arr[], int n)
	    {
	        HashSet<Integer> s=new HashSet<Integer>();
	        int res = 0;
	     
	        for (int i = 0; i < n; i++)
	            s.add(arr[i]);
	     
	        for (int i = 0; i < n; i++) {
	            if (!s.contains(arr[i] - 1)) {
	                int curr = 1;
	                while (s.contains(curr+arr[i]))
	                    curr++;
	                res = Math.max(res, curr);
	            }
	        }
	        return res;
	    }
}