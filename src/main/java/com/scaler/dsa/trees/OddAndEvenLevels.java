package com.scaler.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
NOTE: Consider the level of root node as 1.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 109
Input Format
First and only argument is a root node of the binary tree, A
Output Format
Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.

Input 1:
        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8 
Input 2:
        1
       / \
      2   10
       \
        4

Output 1: 10
Output 2:-7

Explanation 1:
 Sum of nodes at odd level = 23
 Sum of ndoes at even level = 13

Explanation 2:
 Sum of nodes at odd level = 5
 Sum of ndoes at even level = 12
 */
public class OddAndEvenLevels {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		int res = oddEvenOrder(root);
		System.out.println(res);
	}

	public static int oddEvenOrder(TreeNode A) {
		if (A == null)
			return 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		int evenSum = 0;
		int oddSum = 0;
		int level = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			level++;

			while (size > 0) {
				TreeNode f = q.poll();

				if (level % 2 == 0)
					evenSum = evenSum + f.val;
				else
					oddSum = oddSum + f.val;
				if (f.left != null)
					q.add(f.left);
				if (f.right != null)
					q.add(f.right);
				size--;
			}
		}
		return oddSum - evenSum;
	}

}
