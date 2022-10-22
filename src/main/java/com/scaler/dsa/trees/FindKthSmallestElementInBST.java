package com.scaler.dsa.trees;

import java.util.ArrayList;

/*
Problem Description
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9
Input Format
First and only argument is head of the binary tree A.

Output Format
Return an integer, representing the Bth element.

Input 1: 
            2
          /   \
         1    3
B = 2
Input 2: 
            3
           /
          2
         /
        1
B = 1
Output 1: 2
Output 2: 1

Explanation 1:
2nd element is 2.

Explanation 2:
1st element is 1.
 */
public class FindKthSmallestElementInBST {

	static TreeNode root;
	public static void main(String[] args) {
		root = new TreeNode(26);
		root.left = new TreeNode(19);
		root.right = new TreeNode(30);
		root.right.right = new TreeNode(40);

		root.left.left = new TreeNode(15);
		root.left.left.left = new TreeNode(10);
		
		System.out.println(kthsmallest(root,3));
	}

	public static int kthsmallest(TreeNode A, int B) {

		ArrayList<Integer> list = new ArrayList<>();
		inorderTraversal(A, list);

		return list.get(B - 1);
	}

	public static void inorderTraversal(TreeNode node, ArrayList<Integer> list) {
		if (node == null)
			return;
		inorderTraversal(node.left, list);
		list.add(node.val);
		inorderTraversal(node.right, list);
	}
}
