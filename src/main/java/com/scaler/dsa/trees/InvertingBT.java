package com.scaler.dsa.trees;

/*
Problem Description
Given a binary tree A, invert the binary tree and return it.
Inverting refers to making the left child the right child and vice versa.
Problem Constraints
1 <= size of tree <= 100000
Input Format
First and only argument is the head of the tree A.
Output Format
Return the head of the inverted 
Input 1: 
     1
   /   \
  2     3
Input 2: 
     1
   /   \
  2     3
 / \   / \
4   5 6   7
Output 1: 
     1
   /   \
  3     2
Output 2: 
     1
   /   \
  3     2
 / \   / \
7   6 5   4


Explanation 1:
Tree has been inverted.
Explanation 2:
Tree has been inverted.

Observations--1: left node become right and right become left--left-->right && right-->left
			  2: if we can invert left subtree(LST) and right subtree(RST) --swap the inverted sub trees
			  
TC--O(n), SC--O(Height)

 */
public class InvertingBT {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(invertTree(root));

	}

	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode x = invertTree(root.left);
		TreeNode y = invertTree(root.right);
		root.left = y;
		root.right = x;

		return root;
	}
}
