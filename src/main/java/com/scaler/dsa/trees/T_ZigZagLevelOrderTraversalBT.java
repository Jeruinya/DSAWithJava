package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
Given a binary tree, return the zigzag level order traversal of its nodes values. (i.e, from left to right, 
then right to left for the next level and alternate between).

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
Input 2:
   1
  / \
 6   2
    /
   3

Output 1:
 [
   [3],
   [20, 9],
   [15, 7]
 ]
Output 2:
 [ 
   [1]
   [2, 6]
   [3]
 ]

Explanation 1:
 Return the 2D array. Each row denotes the zigzag traversal of each level.
 */
public class T_ZigZagLevelOrderTraversalBT {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(zigzagLevelOrder(root));
		System.out.println(zigzagLevelOrder1(root));
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int level = 2;
		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 1; i <= size; i++) {
				TreeNode f = q.poll();

				temp.add(f.val);
				if (f.right != null) {
					q.add(f.right);
				}
				if (f.left != null) {
					q.add(f.left);
				}
			}
			if (level % 2 == 0) {
				Collections.reverse(temp);
				res.add(temp);
			} else {
				res.add(temp);
			}
			level++;
		}
		return res;
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder1(TreeNode A) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(A);
		q.add(null);

		ArrayList<Integer> level = new ArrayList<>();
		int j = 1;
		while (!q.isEmpty()) {

			TreeNode f = q.poll();
			if (f == null) {
				if (!q.isEmpty()) {
					q.add(null);
					if (j % 2 == 0) {
						Collections.reverse(level);
						res.add(level);
					} else
						res.add(level);
					level = new ArrayList<>();
					j++;
				}
			}
			if (f != null) {
				level.add(f.val);
				if (f.left != null) {
					q.add(f.left);
				}
				if (f.right != null) {
					q.add(f.right);
				}
			}
		}
		if (j % 2 == 0) {
			Collections.reverse(level);
			res.add(level);
		} else
			res.add(level);
		return res;

	}
}
