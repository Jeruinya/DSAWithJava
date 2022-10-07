package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.Stack;

/*
Problem Description
Given a binary tree, return the preorder traversal of its nodes values.
NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the preorder traversal of the given binary tree.

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

Output 1: [1, 2, 3]
Output 2: [1, 6, 2, 3]

Explanation 1:
 The Preoder Traversal of the given tree is [1, 2, 3].

Explanation 2:
 The Preoder Traversal of the given tree is [1, 6, 2, 3].
 */
public class PreorderTraversal {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ArrayList<Integer> res = preOrderTraversalStack(root);
		System.out.println(res);

		ArrayList<Integer> res1 = preOrderTraversalRec(root);
		System.out.println(res1);

	}

	private static ArrayList<Integer> preOrderTraversalRec(TreeNode node) {
		ArrayList<Integer> list = new ArrayList<>();
		printPreOrder(node, list);

		return list;
	}

	public static void printPreOrder(TreeNode node, ArrayList<Integer> list) {

		if (node == null)
			return;

		list.add(node.val);
		printPreOrder(node.left, list);
		printPreOrder(node.right, list);
	}

	private static ArrayList<Integer> preOrderTraversalStack(TreeNode A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (A == null)
			return res;
		stack.push(A);
		TreeNode node;
		while (!stack.isEmpty()) {
			node = stack.pop();
			res.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return res;
	}

}
