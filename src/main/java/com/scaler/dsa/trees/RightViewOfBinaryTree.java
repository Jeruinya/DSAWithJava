package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right 
view of the Binary tree.
Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the right view of the binary tree.

Input 1: 
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2: 
            1
           /  \
          2    3
           \
            4
             \
              5


Output 1: [1, 3, 7, 8]
Output 2: [1, 3, 4, 5]

Explanation 1:
Right view is described.
E
xplanation 2:
Right view is described.

 */
public class RightViewOfBinaryTree {
	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ArrayList<Integer> res = rightViewLevelOrder(root);
		System.out.println(res);

		ArrayList<Integer> res1 = rightViewLevelOrderIterative(root);
		System.out.println(res1);

		ArrayList<Integer> res2 = rightViewLevelOrderRec(root);
		System.out.println(res2);
	}

	public static ArrayList<Integer> rightViewLevelOrder(TreeNode A) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (A == null)
			return ans;

		q.add(A);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode f = q.poll();
				if (i == 0) {
					ans.add(f.val);
				}
				if (f.right != null) {
					q.add(f.right);
				}
				if (f.left != null) {
					q.add(f.left);
				}
			}
		}
		return ans;
	}

	// Iterative Method 2
	public static ArrayList<Integer> rightViewLevelOrderIterative(TreeNode A) {
		if (A == null)
			return null;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		q.add(null);

		ArrayList<Integer> list = new ArrayList<>();
		list.add(A.val);

		while (q.size() > 1) {
			TreeNode f = q.poll();
			if (f == null) {
				q.add(null);
				list.add(q.peek().val);
			} else {
				if (f.right != null) {
					q.add(f.right);
				}
				if (f.left != null) {
					q.add(f.left);
				}
			}
		}
		return list;

	}

	// Using Recursion
	public static ArrayList<Integer> rightViewLevelOrderRec(TreeNode A) {
		ArrayList<Integer> list = new ArrayList<>();
		printLeftView(A, 0, list);

		return list;
	}

	public static void printLeftView(TreeNode root, int level, ArrayList<Integer> list) {

		if (root == null)
			return;
		if (list.size() == level)
			list.add(root.val);

		printLeftView(root.right, level + 1, list);
		printLeftView(root.left, level + 1, list);

	}

	public static ArrayList<Integer> printLeftView(TreeNode root, int level) {
		ArrayList<Integer> list = new ArrayList<>();

		if (root == null)
			return null;
		if (list.size() == level)
			list.add(root.val);
		printLeftView(root.left, level + 1);
		printLeftView(root.right, level + 1);

		return list;
	}
}
