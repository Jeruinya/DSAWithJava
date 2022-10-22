package com.scaler.dsa.trees;

import java.util.ArrayList;

public class PrintRootToLeafPath {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(6);

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();

		findRootToLeafPath(root, list, res);
		System.out.println(res);

	}

	private static void findRootToLeafPath(TreeNode root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			res.add(new ArrayList<>(list));
			list.remove(list.size()-1);
			return;
		}

		list.add(root.val);
		findRootToLeafPath(root.left, list, res);
		findRootToLeafPath(root.right, list, res);

		list.remove(list.size()-1);

		return;

	}

}
