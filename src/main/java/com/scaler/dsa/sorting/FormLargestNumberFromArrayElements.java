package com.scaler.dsa.sorting;
import java.util.Arrays;

/*
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

 */
public class FormLargestNumberFromArrayElements {

	public static void main(String[] args) {
		int A[] = {3, 30, 34, 5, 9};
		int n= A.length;
		
		String s="";
        Arrays.sort(A);
        reverse(A);

        for(int i=0;i<n;i++)
            s=s+A[i];

     System.out.println(s);

    }

    public static void reverse(int arr[]){
        int n= arr.length;
        for(int i=0;i<n/2;i++){
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }
}

