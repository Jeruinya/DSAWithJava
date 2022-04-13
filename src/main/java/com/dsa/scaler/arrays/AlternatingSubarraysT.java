package com.dsa.scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Description You are given an integer array A of length N comprising
 * of 0's & 1's, and an integer B.
 * 
 * You have to tell all the indices of array A that can act as a center of 2 * B+ 1 length 0-1 alternating subarray.
 * 
 * A 0-1 alternating array is an array containing only 0's & 1's, and having no
 * adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1
 * alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
 * 
 * Input Format : First argument is an integer array A and Second argument is an integer B.
 * 
 * Output Format: Return an integer array containing indices(0-based) in sorted
 * order. If no such index exists, return an empty integer array.
 */

public class AlternatingSubarraysT {

	public static void main(String[] args) {
		 int []A = {1, 0, 1, 0, 1};
		int B = 1;
		
		int arr[]=findAlternatingSubarrays(A,B);
		System.out.println(Arrays.toString(arr));
	}
	
	 public static int[] findAlternatingSubarrays(int[] A, int B) {
	        ArrayList < Integer > l1 = new ArrayList < > ();
	        int n = A.length;
	        int len = 2 * B + 1;
	        for (int i = 0; i < n - len + 1; i++) {
	            int curr = -1;
	            int flag = 1;
	            for (int j = i; j < i + len; j++) {
	                if (A[j] == curr) {
	                    flag = 0;
	                    break;
	                }
	                curr = A[j];
	            }
	            if (flag == 1) {
	                l1.add(i + B);
	            }
	        }
	        int[] ret = new int[l1.size()];
	        for (int i = 0; i < l1.size(); i++) {
	            ret[i] = l1.get(i);
	        }
	        return ret;
	    }
	}