package com.scaler.dsa.stack;

import java.util.Stack;

/*
Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000000

Input Format
The only argument given is the integer array A.

Output Format
Return the area of the largest rectangle in the histogram.

Input 1: A = [2, 1, 5, 6, 2, 3]
Input 2: A = [2]

Output 1: 10
Output 2: 2

Explanation 1:
The largest rectangle has area = 10 unit. Formed by A[3] to A[4].

Explanation 2:
Largest rectangle has area 2.

Observations:
1-Length of the largest rectangle will be one of the heights of the Histogram.
2-Based on above point we should try making rectangle for each height and then take maximum.
3-for each height H , we keep going left L and right R till we get a Histogram Bar with height less than H.

Optimization: for each height we need the index of next smaller height both to the left and right of the current index.
Area=(R-L-1)*H

1- We traverse all the heights from left to right, maintain a stack of histogram bar.
2: Every height is pushed to stack once.A height is popped from stack when a bar of smaller height is seen.
3: When a height is popped, we calculate the area with popped height.

How do we get left and right indexes of popped histogram bar?

The current index tell us the right index R and index of previous item in stack is the left index L.

 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int A[] = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRecArea(A));
		System.out.println(largestRectangleArea(A));
		System.out.println(largestRectangleAreaArray(A));

	}

	// Time-O(n) Space-O(n)
	public static int largestRectangleArea(int[] A) {
		Stack<Integer> stack = new Stack<Integer>();
		int ans = -1, n = A.length;

		for (int i = 0; i < A.length; i++) {
			while (!stack.empty() && A[i] < A[stack.peek()]) {
				int ind = stack.peek();
				stack.pop();
				if (!stack.empty())
					ans = Math.max(ans, (i - stack.peek() - 1) * A[ind]);
				else
					ans = Math.max(ans, i * A[ind]);
			}
			stack.push(i);
		}
		while (!stack.empty()) {
			int ind = stack.peek();
			stack.pop();
			if (!stack.empty())
				ans = Math.max(ans, (n - stack.peek() - 1) * A[ind]);
			else
				ans = Math.max(ans, (n) * A[ind]);
		}
		return ans;
	}
	
	//Prateek code
	public static int largestRectangleAreaArray(int[] A) {
        int n=A.length;
        int[] smallerLeft=new int[n];
        int[] smallerRight=new int[n];
        Stack<Integer> s=new Stack<>();
        //prevsmaller
        for(int i=0;i<n;i++){
            int idx=i;
            while(!s.empty()&& A[s.peek()]>= A[idx]){
                s.pop();
            }
            if(s.empty()){
                smallerLeft[i]=-1;//smaller to left
            }else{
                smallerLeft[i]=s.peek();
            }
            s.push(idx);
        }
        Stack <Integer> st=new Stack<>();
        //next smaller
        for(int i=n-1;i>=0;i--){
            int idx=i;
            while(!st.empty() && A[st.peek()]>= A[idx]){
                st.pop();
            }
            if(st.empty()){
                smallerRight[i]=n;
            }else{
                smallerRight[i]=st.peek();
            }
            st.push(idx);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int width=smallerRight[i]-smallerLeft[i]-1;//minus idxes
            int area=A[i]*width;//element of the array which is the height*width
            if(area>maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }

	// Time-O(n^2) Space-O(1)
	private static int largestRecArea(int[] A) {
		int ans = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			int H = A[i];
			int L = i, R = i;
			while (L >= 0 && A[L] >= H)
				L = L - 1;
			while (R < n && A[R] >= H)
				R = R + 1;
			ans = Math.max(ans, (R - L - 1) * H);
		}
		return ans;
	}

}
