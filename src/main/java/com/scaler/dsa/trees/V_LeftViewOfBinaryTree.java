package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
NOTE: The value comes first in the array which have lower level.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 109

Input Format
First and only argument is a root node of the binary tree, A.

Output Format
Return an integer array denoting the left view of the Binary tree.

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

Output 1: [1, 2, 4, 8]
Output 2: [1, 2, 4, 5]
Explanation 1:
 The Left view of the binary tree is returned.
 
From the above we can see that if we print the first node of every level then we can get the Left view of the tree.

 */
public class V_LeftViewOfBinaryTree {
	static TreeNode root;
	static int maxLevel=0;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(leftViewLevelOrder(root));
		System.out.println(leftViewLevelOrderIterative(root));
		System.out.println(leftViewLevelOrderRec(root));
	}

	public static ArrayList<Integer> leftViewLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;

		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode f = q.poll();
				if (i == 0) {
					ans.add(f.val);
				}
				if (f.left != null) {
					q.add(f.left);
				}
				if (f.right != null) {
					q.add(f.right);
				}
			}
		}
		return ans;
	}

	// Iterative Method 2
	public static ArrayList<Integer> leftViewLevelOrderIterative(TreeNode root) {
		if (root == null)
			return null;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		ArrayList<Integer> list = new ArrayList<>();
		list.add(root.val);

		while (q.size() > 1) {
			TreeNode f = q.poll();
			if (f == null) {
				q.add(null);
				list.add(q.peek().val);
			} else {
				if (f.left != null) {
					q.add(f.left);
				}
				if (f.right != null) {
					q.add(f.right);
				}
			}
		}
		return list;

	}

	// Using Recursion
	public static ArrayList<Integer> leftViewLevelOrderRec(TreeNode A) {
		ArrayList<Integer> list = new ArrayList<>();
		printLeftView(A, 1, list);

		return list;
	}

	public static void printLeftView(TreeNode root, int level, ArrayList<Integer> list) {

		if (root == null)
			return;
		if (level>maxLevel) {
			list.add(root.val);
			maxLevel= level;
		}

		printLeftView(root.left, level + 1, list);
		printLeftView(root.right, level + 1, list);

	}
}
