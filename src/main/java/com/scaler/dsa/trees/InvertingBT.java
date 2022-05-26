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
Return the head of the inverted tree.
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

	TreeNode A;

	InvertingBT() {
		A = null;
	}

	private void printInvet() {
		TreeNode node = invertTree(A);
		// print the nodes
		System.out.println(node);

	}

	public TreeNode invertTree(TreeNode A) {
		if (A == null)
			return null;
		TreeNode x = invertTree(A.left);
		TreeNode y = invertTree(A.right);
		A.left = y;
		A.right = x;

		return A;
	}

	public static void main(String[] args) {
		InvertingBT tree = new InvertingBT();
		tree.A = new TreeNode(1);
		tree.A.left = new TreeNode(2);
		tree.A.right = new TreeNode(3);
		tree.A.left.left = new TreeNode(4);
		tree.A.left.right = new TreeNode(5);

		tree.printInvet();

	}
}
