package com.scaler.dsa.trees;

import java.util.ArrayList;

/*
Find the distance between two keys in a binary tree, no parent pointers are given. 
The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.
 */
public class FindShortestDistanceBtwTwoNodesBT {

	static TreeNode root;

	public static void main(String[] args) {
		root = new TreeNode(3);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(18);
		root.right.left.left.left = new TreeNode(33);
		root.right.left.left.right = new TreeNode(12);
		root.right.left.left.right.left = new TreeNode(19);
		root.right.left.left.right.left.left = new TreeNode(17);
		root.right.left.left.left.left = new TreeNode(41);
		

		System.out.println(shortestPathBtwTwoNodes(root, 41, 17));
	}

	private static int shortestPathBtwTwoNodes(TreeNode root, int a, int b) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		boolean b1 = findPath(root, list1, a);
		boolean b2 = findPath(root, list2, b);
		int n1 = list1.size() - 1;
		int n2 = list2.size() - 1;
		ArrayList<Integer> res = new ArrayList<>();

		int i;
		for (i = 0; i < Math.min(list1.size(), list2.size()); i++) {
			if (list1.get(i) != list2.get(i))
				break;
		}
		
		i=i-1;
		while (i <= n1) {
			res.add(list1.get(n1));
			n1--;
		}

		i=i+1;
		while (i <= n2) {
			res.add(list2.get(i));
			i++;
		}
		System.out.println(res);
		return res.size();
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
