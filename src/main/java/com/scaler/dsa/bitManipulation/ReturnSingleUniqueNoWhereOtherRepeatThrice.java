package com.scaler.dsa.bitManipulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Description
Given an array of integers, every element appears thrice except for one, which occurs once.
Find that element that does not appear thrice.
NOTE: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Problem Constraints
2 <= A <= 5*106
0 <= A <= INTMAX
Input Format
First and only argument of input contains an integer array A.
Output Format
Return a single integer.

Input 1: A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2: A = [0, 0, 0, 1]

Output 1: 4
Output 2: 1

Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
 
 A[]={6,5,8,7,7,8,8,5,2,5,6,6,7}
 */
public class ReturnSingleUniqueNoWhereOtherRepeatThrice {

	public static void main(String[] args) {
		int A[] = { 6, 5, 8, 7, 7, 8, 8, 5, 2, 5, 6, 6, 7 };
		System.out.println(findNonRepeatedNumNaive(A));
		System.out.println(findNonRepeatedEff(A));
		System.out.println(findNonRepeatedMoreEff());

	}

	// TC-O(N^2) SC-O(1)
	private static int findNonRepeatedNumNaive(int[] A) {

		for (int i = 0; i < A.length; i++) {
			int num = A[i];
			int count = 1;
			for (int j = 0; j < A.length; j++) {
				if (i != j && num == A[j])
					count++;
			}
			if (count == 1)
				return A[i];
		}
		return 0;
	}

	// TC-O(N) SC-O(n)
	private static int findNonRepeatedEff(int[] A) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i]))
				hm.put(A[i], hm.get(A[i]) + 1);
			else
				hm.put(A[i], 1);
		}

		for (Map.Entry<Integer, Integer> entry : hm.entrySet())
			if (entry.getValue() == 1)
				return entry.getKey();

		return 0;

	}
	
	public static int findNonRepeatedMoreEff(){
        int[] arr = {6,5,8,7,7,8,8,5,2,5,6,6,7};
        //int n = arr.length;

        int[] freq = new int[32];

        for(int x : arr){
            //extract every bit of given number and add it to the sum at correct indx (j)
            int j = 0;
            while(x>0){
                int lastBit = (x&1);
                if(lastBit==1){
                    freq[j]++;
                }
                j++;
                x = x>>1;
            }
        }

        //iterate over the freq array to generate the number
        int p=1;
        int ans = 0;
        for(int x : freq){
            ans = ans + (x%3)*p;
            p = p<<1;
        }
       // System.out.println(ans);


        // Freq Array
       // System.out.println(Arrays.toString(freq));
        return ans;
    }
	
	public int singleNumber(final List < Integer > A) {
        int[] bits = new int[32];
        for (int num: A) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }
        int number = 0;
        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }
        return number;
    }
}
