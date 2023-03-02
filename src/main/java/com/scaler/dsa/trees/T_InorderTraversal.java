package com.scaler.dsa.trees;

import java.util.ArrayList;
/*
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.
NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 105
Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

Input 1:
   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3

Output 1: [1, 3, 2]
Output 2: [6, 1, 3, 2]

Explanation 1:
 The Inorder Traversal of the given tree is [1, 3, 2].

Explanation 2:
 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
public class T_InorderTraversal {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ArrayList<Integer> res = inorderTraversal(root);
		System.out.println(res);

		ArrayList<Integer> res1 = inorderTraversalRec(root);
		System.out.println(res1);
	}

	public static ArrayList<Integer> inorderTraversal(TreeNode A) {
		TreeNode current, node;
		ArrayList<Integer> res = new ArrayList<>();
		current = A;
		while (current != null) {
			if (current.left == null) {
				res.add(current.val);
				current = current.right;
			} else {
				node = current.left;
				while (node.right != null && !current.equals(node.right))
					node = node.right;

				if (node.right == null) {
					node.right = current;
					current = current.left;
				} else {
					current = node.right;
					node.right = null;
					res.add(current.val);
					current = current.right;
				}
			}
		}
		return res;
	}

	public static ArrayList<Integer> inorderTraversalRec(TreeNode A) {
		ArrayList<Integer> list = new ArrayList<>();
		printInorder(A, list);

		return list;
	}

	public static void printInorder(TreeNode node, ArrayList<Integer> list) {

		if (node == null)
			return;

		printInorder(node.left, list);
		list.add(node.val);
		printInorder(node.right, list);
	}
}
