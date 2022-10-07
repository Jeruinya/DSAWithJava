package com.scaler.dsa.trees;

import java.util.ArrayList;

/*
Problem Description
Given a root of binary tree A, determine if it is height-balanced.
A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never 
differ by more than 1.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the root of the tree A.

Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Input 1:
    1
   / \
  2   3
Input 2: 
       1
      /
     2
    /
   3

Output 1:1
Output 2:0

Explanation 1:
It is a complete binary tree.

Explanation 2:
Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
Difference = 2 > 1.
 */
public class BalancedBinaryTree {

	static TreeNode root;
	static int balanced = 1;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(isBalanced(root));
		System.out.println(isBalanced1(root));
	}

	public static int isBalanced(TreeNode A) {

		boolean res = isBalancedTree(A);

		return res == true ? 1 : 0;
	}

	public static boolean isBalancedTree(TreeNode root) {
		if (root == null)
			return true;

		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1)
			return false;
		return isBalancedTree(root.left) && isBalancedTree(root.right);
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));

	}

	public static int isBalanced1(TreeNode A) {
		balanced(A);
		return balanced;
	}

	public static int balanced(TreeNode A) {
		if (A == null)
			return 0;

		int heightLeft = 1 + balanced(A.left);
		int heightRight = 1 + balanced(A.right);

		if (Math.abs(heightLeft - heightRight) > 1)
			balanced = 0;
		return Math.max(heightLeft, heightRight);
	}

}
