package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.Stack;

/*
Problem Description
Given a binary tree, return the Postorder traversal of its nodes values.
NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.

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

Output 1: [3, 2, 1]
Output 2: [6, 3, 2, 1]

Explanation 1:
 The Preoder Traversal of the given tree is [3, 2, 1].

Explanation 2:
 The Preoder Traversal of the given tree is [6, 3, 2, 1].
 */
public class PostorderTraversal {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ArrayList<Integer> res = postOrderTraversalStack(root);
		System.out.println(res);

		ArrayList<Integer> res1 = postOrderTraversalRec(root);
		System.out.println(res1);

	}

	private static ArrayList<Integer> postOrderTraversalRec(TreeNode A) {
		ArrayList<Integer> list = new ArrayList<>();
		printPostOrder(A, list);

		return list;
	}

	public static void printPostOrder(TreeNode node, ArrayList<Integer> list) {

		if (node == null)
			return;

		printPostOrder(node.left, list);
		printPostOrder(node.right, list);
		list.add(node.val);
	}

	private static ArrayList<Integer> postOrderTraversalStack(TreeNode A) {
		Stack<TreeNode> stack1, stack2;
		ArrayList<Integer> postorder;
		TreeNode node;
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		postorder = new ArrayList<>();
		if (A == null)
			return null;
		stack1.push(A);
		while (!stack1.isEmpty()) {
			node = stack1.pop();
			stack2.push(node);
			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
		}
		while (!stack2.isEmpty()) {
			node = stack2.pop();
			postorder.add(node.val);
		}
		return postorder;
	}
}
