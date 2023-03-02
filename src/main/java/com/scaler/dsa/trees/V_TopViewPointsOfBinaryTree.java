package com.scaler.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import com.scaler.dsa.trees.V_VerticalPointsInBinaryTree.Pair;

/*
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
Return the nodes in any order.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an array, representing the top view of the binary tree.

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

Output 1: [1, 2, 4, 8, 3, 7]
Output 2: [1, 2, 3]

Explanation 1:
Top view is described.

Explanation 2:
Top view is described.

Approach: we need hashmap + level order traversal

 */
public class V_TopViewPointsOfBinaryTree {

	static class Pair {
		TreeNode t;
		int x;

		Pair(TreeNode t, int x) {
			this.t = t;
			this.x = x;
		}
	}

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);

		System.out.println(topView(root));
		System.out.println(topViewSimple(root));
	}

	public static ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();

		ArrayList<Integer> ar = new ArrayList<Integer>();
		if (root == null) {
			return ans;
		}

		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int v = p.t.val;
			int x = p.x;
			ar = new ArrayList<Integer>();
			if (tm.containsKey(x)) {
				ar = tm.get(x);
				ar.add(v);
			} else {
				ar.add(v);
			}

			tm.put(x, ar);
			if (p.t.left != null) {
				q.add(new Pair(p.t.left, x - 1));
			}
			if (p.t.right != null) {
				q.add(new Pair(p.t.right, x + 1));
			}
		}
		for (int x : tm.keySet()) {
			int num = tm.get(x).get(0);
			ans.add(num);
		}
		return ans;
	}

	public static ArrayList<Integer> topViewSimple(TreeNode A) {
		ArrayList<Integer> arr = new ArrayList<>();
		TreeNode curr = A;

		// START FROM ROOT AND TRAVERSE TILL END OF LEFT
		while (curr != null) {
			arr.add(curr.val);
			curr = curr.left;
		}

		// COME BACK TO ROOT
		if (A.right != null) {
			curr = A.right;
		}

		// START FROM ROOT AND TRAVERSE TILL END OF RIGHT
		while (curr != null) {
			arr.add(curr.val);
			curr = curr.right;
		}

		return arr;
	}
}
