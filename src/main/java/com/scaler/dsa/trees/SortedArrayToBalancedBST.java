package com.scaler.dsa.trees;

/*
Problem Description
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of 
every node never differ by more than 1.
Problem Constraints
1 <= length of array <= 100000

Input Format
First argument is an integer array A.
Output Format
Return a root node of the Binary Search Tree.

Input 1: A : [1, 2, 3]
Input 2: A : [1, 2, 3, 5, 10]

Output 1:
      2
    /   \
   1     3
Output 2:
      3
    /   \
   2     5
  /       \
 1         10

Explanation 1:
 You need to return the root node of the Binary Tree.
 */
public class SortedArrayToBalancedBST {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 5, 10 };
		TreeNode root = sortedArrayToBST(A);

	}

	public static TreeNode sortedArrayToBST(final int[] A) {
		TreeNode root = createBST(A, 0, A.length - 1);
		return root;
	}

	public static TreeNode createBST(int A[], int s, int e) {
		if (s > e)
			return null;
		int mid = (s + e) / 2;
		TreeNode root = new TreeNode(A[mid]);
		root.left = createBST(A, s, mid - 1);
		root.right = createBST(A, mid + 1, e);

		return root;

	}
}
