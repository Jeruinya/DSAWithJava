package com.scaler.dsa.trees;

import java.util.ArrayList;

public class LCABT {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);

		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);

		System.out.println(lcaOfTree(root, 20, 80));
	}

	private static int lcaOfTree(TreeNode root, int a, int b) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		boolean b1 = findPath(root, list1, a);
		boolean b2 = findPath(root, list2, b);
		int i;
		for (i = 0; i < Math.min(list1.size(), list2.size()); i++) {
			if (list1.get(i) != list2.get(i))
				break;
		}

		return list1.get(i - 1);
	}

	private static boolean findPath(TreeNode A, ArrayList<Integer> list, int B) {
		if (A == null)
			return false;
		list.add(A.val);

		if (A.val == B)
			return true;

		if (findPath(A.left, list, B) || findPath(A.right, list, B))
			return true;
		list.remove(list.size() - 1);
		return false;
	}

}
