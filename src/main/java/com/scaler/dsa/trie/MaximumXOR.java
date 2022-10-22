package com.scaler.dsa.trie;

/*
Problem Description
Given an array of integers A, find and return the maximum result of A[i] XOR A[j], 
where i, j are the indexes of the array.

Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return an integer denoting the maximum result of A[i] XOR A[j].

Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11]

Output 1: 7
Output 2: 117

Explanation 1:
 Maximum XOR occurs between element of indices(0-based) 1 and 4 i.e. 2 ^ 5 = 7.

Explanation 2:
 Maximum XOR occurs between element of indices(0-based) 1 and 2 i.e. 17 ^ 100 = 117.

Optimization:Trie on bits
 
left child will store 0 and right child will store 1.
We can assume if sum node in the left exist then it will be 0 and if some node in the right exists it will be 1.
Hint-Instead of doing all XORs, do it for every number such that XOR can be maximized. 

A[] = { 3,10,5,25,9,2}
3- 	0 0 0 1 1
10- 0 1 0 1 0
5-  0 0 1 0 1
25- 1 1 0 0 1
9-  0 1 0 0 1
2-  0 0 0 1 0

Result will contain only in maximum of 5 bits.
To maximize the result more number of bits should be set bit and most of the bits should come in the left side.

Build Trie of Array elements.

Pick every number once and find another number that produces maximum XOR

Num1= 25^ 	1 1 0 0 1
Num2        0 0 1 0 1
		  --------------
		    1 1 1 0 0= 28 which is maximum
		    
* So here i picked number 25 and tried to maximizing it by checking if A bit is 1 then check if there 
  exist a 0 bit and vice versa.
* Here to traverse from root to leaf 5 steps is required in this case. In case of 32 bit integer it will be 32 steps.

So the time complexity to find the largest XOR is O(n* length of bits)=> O(n*32)=> O(n)



 */
public class MaximumXOR {
	static private class TrieNode {
		TrieNode left = null; // left points to 0
		TrieNode right = null; // right points to 1
	}

	static TrieNode root;

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5 };

		System.out.println(maxXorNaive(A));
		root = new TrieNode();
		System.out.println(maxPairSolver(A));

	}

	private static int maxPairSolver(int A[]) {
		for (int x : A)
			insert(x);
		int curr_max = 0;
		int ans = 0;
		for (int x : A) {
			curr_max = findCurrentMaxXor(x);
			ans = Math.max(curr_max, ans);
		}
		return ans;
	}

	private static void insert(int x) {
		TrieNode temp = root;
		for (int j = 31; j >= 0; j--) {
			int bit = (x >>> j) & 1;
			if (bit == 0) {
				if (temp.left == null) {
					temp.left = new TrieNode();
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = new TrieNode();
				}
				temp = temp.right;
			}
		}

	}

	private static int findCurrentMaxXor(int x) {
		TrieNode temp = root;
		int currSum = 0;
		for (int i = 31; i >= 0; i--) {
			int bit = (x >>> i) & 1;
			if (bit == 0) {
				if (temp.right != null) {
					currSum += (int) (Math.pow(2, i));
					// currSum += (1 >> i); this one not giving result as expected 
					temp = temp.right;
				} else {
					temp = temp.left;
				}
			} else {
				if (temp.left != null) {
					currSum += (int) (Math.pow(2, i));
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}
		}
		return currSum;
	}

	// Time-O(n^2)
	public static int maxXorNaive(int[] A) {

		int res = 0;
		for (int i = 0; i < A.length; i++)
			for (int j = i + 1; j < A.length; j++)
				res = Math.max(A[i] ^ A[j], res);

		return res;
	}

}
