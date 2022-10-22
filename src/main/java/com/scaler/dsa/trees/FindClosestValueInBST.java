package com.scaler.dsa.trees;

/*
Given a binary search tree and a target node K. The task is to find the node with a minimum absolute 
difference with the given target value K.

From below code form the tree 
Input :  k = 18
Output:  17

Input :  k = 12
Output:  9

Input:  k=2
Output:  3

Brute force: Traverse and  track the minimum distance for each node.

 */
public class FindClosestValueInBST {

	static TreeNode root;
	static int min_diff = Integer.MAX_VALUE;
	static int ans = -1;

	public static void main(String[] args) {
		root = new TreeNode(9);
		root.left = new TreeNode(4);
		root.right = new TreeNode(17);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(7);
		root.right.right = new TreeNode(22);
		root.right.right.left = new TreeNode(20);
		int k = 18;
		System.out.println(closestInBST(root, k));

		System.out.println(closestInBSTRecursive(root, k, min_diff, ans));

	}

	private static int closestInBSTRecursive(TreeNode root, int T, int minDiff, int ans) {

		if (root == null)
			return ans;
		// current node
		int d = Math.abs(T - root.val);
		if (d < minDiff) {
			ans = root.val;
			minDiff = d;
		}
		// go left
		if (root.val > T)
			return closestInBSTRecursive(root.left, T, minDiff, ans);
		//go right
		else
			return closestInBSTRecursive(root.right, T, minDiff, ans);
	}

	private static int closestInBST(TreeNode root, int T) {
		TreeNode temp = root;
		int minDiff = Integer.MAX_VALUE;
		int ans = -1;
		while (temp != null) {
			int d = Math.abs(T - temp.val);
			if (d < minDiff) {
				ans = temp.val;
				minDiff = d;
			}
			if (temp.val < T)
				temp = temp.right;
			else if (temp.val > T)
				temp = temp.left;
			else
				return temp.val;
		}

		return ans;
	}
}
