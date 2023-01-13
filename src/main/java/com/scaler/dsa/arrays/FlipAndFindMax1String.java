package com.scaler.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. 
In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N 
and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two 
elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Problem Constraints
1 <= size of string <= 100000
Input Format
First and only argument is a string A.
Output Format
Return an array of integers denoting the answer.

Input 1:A = "010"
Input 2:A = "111"

Output 1:[1, 1]
Output 2:[]

Explanation 1:A = "010"

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].

Observation:
1-convert the string to array/Arraylist where each 1 will be converted to -1 and each zero will be converted to 1.
2-now apply Kadane's Algorithm to find the maximum sum subarray and find the index of this.
2-Add one to starting and ending index and return.
 */
public class FlipAndFindMax1String {

	public static void main(String[] args) {
		String A="011";
		
		ArrayList<Integer> resList=flip(A);
		System.out.println(resList);
		
		int arr[]=flips(A);
		System.out.println(Arrays.toString(arr));
		

	}

	public static ArrayList<Integer> flip(String A) {
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> pair = new ArrayList<>();

		boolean flag = true;

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '0') {
				flag = false;
				arr.add(1);
			} else {
				arr.add(-1);
			}
		}
		if (flag)
			return pair;

		int currSum = 0;
		int maxSum = 0;
		int l = 0;
		int r = 0;

		for (int i = 0; i < arr.size(); i++) {
			currSum += arr.get(i);

			if (currSum > maxSum) {
				pair.clear();
				maxSum = currSum;
				r = i;
				pair.add(l + 1);
				pair.add(r + 1);

			}
			if (currSum < 0) {
				currSum = 0;
				l = i + 1;
			}
		}
		return pair;

	}
	
	 public static int[] flips(String A) {
	        boolean flag=true;       

	        ArrayList<Integer> arr=new ArrayList<>();
	        int res[]= new int[0];
	        
	        for(int i=0;i<A.length();i++){
	            if(A.charAt(i)=='0'){
	                flag=false;
	                arr.add(1);
	                
	            }else
	                arr.add(-1);
	        }
	        if(flag==true)
	            return res;

	        int l=0;
	        int r=0;
	        int s=0;
	        int currSum=0;
	        int maxSum=0;

	        for(int i=0;i<arr.size();i++){
	            currSum=currSum+arr.get(i);
	            if(currSum>maxSum){
	                maxSum=currSum;
	                r=i;
	                s=l;	                
	            }
	            if(currSum<0){
	                currSum=0;
	                l=i+1;
	            }
	        }
	        res=new int[2];
	        res[0]=s+1;
	        res[1]=r+1;
	        return res;
	        
	    }

}
