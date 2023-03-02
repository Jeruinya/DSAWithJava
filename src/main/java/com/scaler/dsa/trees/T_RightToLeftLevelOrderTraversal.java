package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from right to left, level by level).

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

Input 1:
    3
   / \
  9  20
    /  \
   15   7

Output: 3 20 9 7 15
 */
public class T_RightToLeftLevelOrderTraversal {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		ArrayList<ArrayList<Integer>> res = levelOrder(root);
		System.out.println(res);
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();

		q.add(A);
		q.add(null);
		ArrayList<Integer> level = new ArrayList<>();

		while (!q.isEmpty()) {

			TreeNode f = q.poll();

			if (f == null) {
				if (!q.isEmpty()) {
					q.add(null);
					res.add(level);
					level = new ArrayList<>();
				}
			}

			if (f != null) {
				level.add(f.val);
				if (f.right != null) {
					q.add(f.right);
				}
				if (f.left != null) {
					q.add(f.left);
				}
			}
		}
		res.add(level);
		return res;
	}
}