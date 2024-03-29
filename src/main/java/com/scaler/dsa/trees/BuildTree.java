package com.scaler.dsa.trees;
/*
Given a list of data build binary tree from it.
insert 1 2 4 -1 -1 5 -1 -1 3 -1 -1
	 1
	/ \
   2   3
  / \
 4   5   

*/
import java.util.ArrayList;
import java.util.Scanner;

public class BuildTree {

	public static void main(String[] args) {
		TreeNode root= buildTree();
		System.out.println(preOrderTraversalRec(root));
		

	}
//insert 1 2 4 -1 -1 5 -1 -1 3 -1 -1
	private static TreeNode buildTree() {
		Scanner s= new Scanner(System.in);
		int val=s.nextInt();
		if(val==-1)
			return null;
		TreeNode root= new TreeNode(val);
		root.left=buildTree();
		root.right=buildTree();
		
		return root;
	}

	private static ArrayList<Integer> preOrderTraversalRec(TreeNode node) {
		ArrayList<Integer> list = new ArrayList<>();
		printPreOrder(node, list);

		return list;
	}

	public static void printPreOrder(TreeNode node, ArrayList<Integer> list) {

		if (node == null)
			return;

		list.add(node.val);
		printPreOrder(node.left, list);
		printPreOrder(node.right, list);
	}
}
